package com.snsoft.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String time = request.getParameter("time");
		
//		response.getWriter().write(username + "-->" + password); 
		System.out.println(username + "-->" + password);
		//参数校验
		if(!(username != null && username.trim().length() > 0)){
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			return;
		}
		if(!(password != null && password.trim().length() > 0)){
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			return;
		}
		if(!(time != null && time.trim().length() > 0)){
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			return;
		}
		
		
		//数据库密码验证，假装验证通过
		if(true){
			//登录成功，将信息绑定到HttpSession域对象中
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("password", password);
			//解决cookie中文乱码问题
			String userinfo = URLEncoder.encode(username + "_" + password, "UTF-8");
			
			//向浏览器写入Cookie
			Cookie cookie = new Cookie("userinfo", userinfo);
			cookie.setMaxAge(Integer.parseInt(time));
			response.addCookie(cookie);
			
			//重定向到welcome.jsp页面
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
		}
		
	}

}
