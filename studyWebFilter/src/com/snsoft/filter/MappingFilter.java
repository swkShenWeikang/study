package com.snsoft.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 过滤细节
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, 
		DispatcherType.INCLUDE}, urlPatterns = { "/*" })
public class MappingFilter implements Filter {

    public MappingFilter() {
        // TODO Auto-generated constructor stub
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	// TODO Auto-generated method stub
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MappingFilter::doFilter->A");
		chain.doFilter(request, response);
		System.out.println("MappingFilter::doFilter->B");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
