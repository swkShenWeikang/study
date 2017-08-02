package com.snsoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {
    
	/**
	 * Filter生命周期：
	 * 		1.先调用空参构造方法，1次
	 * 		2.调用初始化方法init(FilterConfig arg0)，1次
	 * 		3.外界请求时，调用doFilter方法拦截，N次，与请求次数有关
	 * 		4.销毁时调用destroy()方法，1次，服务器关闭或项目重新部署
	 */
	public FilterDemo1() {
		super();
		System.out.println("FilterDemo1");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("111AAA...");
		//放行请求
		chain.doFilter(request, response);
		System.out.println("111BBB...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
