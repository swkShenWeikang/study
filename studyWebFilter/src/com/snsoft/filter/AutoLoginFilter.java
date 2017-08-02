package com.snsoft.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自动登录拦截器
 */
@WebFilter("/welcome.jsp")
public class AutoLoginFilter implements Filter {

    public AutoLoginFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//取得浏览器的Cookie
		Cookie[] cookies = request.getCookies();
		Cookie userCookie = null;
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if("userinfo".equals(cookie.getName())){
					userCookie = cookie;
					break;
				}
			}
			//如果找到cookie
			if(userCookie != null){
				String userinfo = userCookie.getValue();
				System.out.println("-->" + userinfo);
				userinfo = URLDecoder.decode(userinfo, "UTF-8");
				String[] infos = userinfo.split("_");
				String username = infos[0];
				String password = infos[1];
				
				//数据库密码验证，假装验证通过
				//登录成功，将信息绑定到HttpSession域对象中
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
			}
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
