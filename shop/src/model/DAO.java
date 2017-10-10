package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DAO {
	private static ArrayList<Goods> goods = new ArrayList<Goods>();
	private static String userFromDB = new String();
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/shop";
		String login = "root";
		String pass = "";
		return DriverManager.getConnection(url,login,pass);
	}
	
	public static boolean authUser(String login) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT user FROM users");
		
		while(rs.next()){
			userFromDB = rs.getString("user");
			System.out.println(userFromDB);//!!!
			if (userFromDB.equals(login)){
				rs.close();
				stmt.close();
				return true;
			}
		}
		System.out.println(false);//!!!
		rs.close();
		stmt.close();
		return false;
	}
	
	public static ArrayList<Goods> getGoods() throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM goods");
		goods.clear();
		while(rs.next()){
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int price = rs.getInt("price");
			goods.add(new Goods(id,title,price));
		}
		rs.close();
		stmt.close();
		
		return goods;		
		
		
	}

	public static boolean addToBasket(int id_good) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		if(stmt.executeUpdate("insert into basket(id_good) values("+id_good+")")>0)
			return true;
		return false;
	}
	
	public static ArrayList<BasketInit> getGoodsFromBasket() throws ClassNotFoundException, SQLException{
		ArrayList<BasketInit> basket = new ArrayList<BasketInit>();
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT goods.title as title,goods.price as price FROM goods inner join basket on goods.id=basket.id_good");
		
		while(rs.next()){
			//System.out.println("test");
			String title = rs.getString("title");
			int price = rs.getInt("price");
			basket.add(new BasketInit(title,price));
		}
		rs.close();
		stmt.close();
		
		return basket;				
		
	}


	
	
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(getGoodsFromBasket());
	}*/
}
