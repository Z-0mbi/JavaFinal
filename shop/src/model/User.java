package model;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class User {
	private static String login;
	private static String telNamber;
	private static String pass;
	private static String pass2;
	static Pattern p;
	static Matcher m;
	
	public User(HttpServletRequest request){
		this.login = request.getParameter("login");
		this.telNamber = request.getParameter("telNamber");
		this.pass = request.getParameter("pass");
		this.pass2 = request.getParameter("pass2");
	}
	
	public static boolean checkAuth(String login) throws ClassNotFoundException, SQLException{
		return DAO.authUser(login);
		//if()
	}
	
	public String checkAll(){
		String ansver = "";
		ansver = checkLogin(login);
		if (ansver.length() > 0){
			System.out.println(ansver);
			return ansver;
		}
		ansver = checkTelNamber(telNamber);
		if (ansver.length() > 0){
			return ansver;
		}
		ansver = checkPass(pass, pass2);
		System.out.println(ansver);
		System.out.println("3");
		return ansver;
	}
	
	
	private static String checkLogin(String login){
		if(login == null){
			return "Вы не ввели логин";
		}
		p = Pattern.compile("^.{3,}$");
		m = p.matcher(login);
		if(!m.matches()){
			return "Логин должен быть не менее трех символов"; 
		}
		p = Pattern.compile("^[a-zA-Z0-9_-]+$");
		m = p.matcher(login);
		if(!m.matches()){
			return "Логин может состоять только из букв латинского алфавита, _ и -"; 
		}
		return "";
	}
	private static String checkTelNamber(String telNamber){
		p = Pattern.compile("^[78][0-9]{10}$");
		m = p.matcher(telNamber);
		if(!m.matches()){
			return "Не правильный формат телефона"; 
		}
		return "";
	}
	private static String checkPass(String pass, String pass2){
		p = Pattern.compile("^.{8,}$");
		m = p.matcher(pass);
		if(!m.matches()){
			return "Пароль должен содержать не менее 8 символов"; 
		}
		if(pass == pass2){
			System.out.println(pass);
			System.out.println(pass2);
			return "Пароли не совпадают"; 
		}
		return "";
	}
}
