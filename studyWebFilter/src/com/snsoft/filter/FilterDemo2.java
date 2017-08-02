package com.snsoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FilterDemo2 implements Filter {

	private FilterConfig fConfig;
	
    public FilterDemo2() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	this.fConfig = fConfig;
    }
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		String encoding = fConfig.getInitParameter("encoding");
		
		//NO将父子接口强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//请求编码设置
		request.setCharacterEncoding(encoding);
		//响应编码设置
		response.setContentType("text/html;charset=" + encoding);
		
		//资源缓存处理
		//NO1取得客户端访问的资源的URI，形式/studyWebFilter/login.jsp
		String uri = request.getRequestURI();
		
		//NO2判断是否以jsp结尾，即动态资源
		if(uri!=null && uri.endsWith("jsp")){
			//NO3如果是动态资源，设置三个响应头通知浏览器不缓存
			response.setHeader("expires", "-1");
			response.setHeader("cache-control", "no-cache");
			response.setHeader("pragma", "no-cache");
		}else if(uri!=null && uri.endsWith("html")){
			//NO4如果是静态资源，缓存一定的时间
			String strHtml = fConfig.getInitParameter("html");
			long time = System.currentTimeMillis() + Integer.parseInt(strHtml) * 1000;
			//time为毫秒值
			response.setDateHeader("expires", time);
			response.setHeader("cache-control", time / 1000 + "");
			response.setHeader("pragma", time / 1000 + "");
		}
		
		//放行资源
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
	

}
