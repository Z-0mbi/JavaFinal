package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/Catalog", "/goods", "/catalog" })
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(request.getCookies().length == 0){
				Cookie theCookie = new Cookie("user", ""); 			
				response.addCookie( theCookie );
			}
			if(request.getParameter("id_good")==null){
				request.setCharacterEncoding("UTF-8");	
				try {
					request.setAttribute("goods", model.DAO.getGoods());//******
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				response.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
			}
			else{
				int id_good = Integer.parseInt(request.getParameter("id_good"));
				if(id_good>0){
					try {
						if(model.DAO.addToBasket(id_good)){
							request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request, response);
						}
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
