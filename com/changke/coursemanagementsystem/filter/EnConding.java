package com.changke.coursemanagementsystem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class EnConding extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private String init;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(init);
		response.setCharacterEncoding(init);
		response.setContentType("text/html");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		init = fConfig.getInitParameter("encoding");
		System.err.println(init);
		if (init == null) {
			init = "UTF-8";
		}
	}
}
