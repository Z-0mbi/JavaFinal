/*
 *Сдесь пока только проверка с регулярными вырожениями 
 **/

package controller;

import model.DAO;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/SignIn", "/Registration" })
public class SignIn extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		request.setCharacterEncoding("UTF-8");		
		
		String login = request.getParameter("login");
		String telNamber = request.getParameter("telNamber");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");		  
		
		String ansver = new User(request).checkAll();//проверка правильности заполнения
		if(request.getContentLength() > 30){//начальная длина адреса страницы 30			
			request.setAttribute("ansver", ansver);
		}		
		if(ansver == ""){
			Cookie cookie = new Cookie("user", login);
			response.addCookie(cookie);
			
			request.setAttribute("user", login);
			request.getRequestDispatcher("/catalog").forward(request, response);			
		}
		else{
			request.getRequestDispatcher("WEB-INF/views/signIn.jsp").forward(request, response);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
