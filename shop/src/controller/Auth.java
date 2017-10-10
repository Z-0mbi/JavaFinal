package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		Cookie theCookie = new Cookie("user", login);
		response.addCookie( theCookie );
		
		if(login != null && login.equals("")){
			request.getRequestDispatcher("WEB-INF/views/auth.jsp").forward(request, response);
		}
		else{ 
			//Сделал сравнение куки с определенным значением
			//Надо переделать: просто узнать есть ли логин и если есть то вывести
			//Выводить значения из куки не удобно, лучше создать сессию для отображения
			
			boolean flag = false;//если значения совпадут поставим flag=true
			if(request.getCookies().length != 0){
				Cookie[] dataSaved = new Cookie[request.getCookies().length];
				dataSaved = request.getCookies();
			
				for (int i = 0; i < request.getCookies().length; i++){
					Cookie cookie = dataSaved[i];
					if(cookie.getValue().equals("test1")){
						flag = true;					
					}
				}
			}//if(request.getCookies().length != 0)
			
			if(flag){
				request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request, response);
			}//if(flag)
			else{
				request.getRequestDispatcher("WEB-INF/views/auth.jsp").forward(request, response);
			}//else (flag)
		}//else login.equals("")
		
		/*try {
			if(User.checkAuth(login)){
				request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("WEB-INF/views/auth.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
