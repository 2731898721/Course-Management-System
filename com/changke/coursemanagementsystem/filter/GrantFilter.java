package com.changke.coursemanagementsystem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class GrantFilter
 */
public class GrantFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;
		String uri = request.getRequestURI();
		//System.err.println(uri); // 得到的是工程名下的相对路径

		if (uri.contains("login.jsp")) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect("/selectingcourses/common/login.jsp");
		}
	}
}
