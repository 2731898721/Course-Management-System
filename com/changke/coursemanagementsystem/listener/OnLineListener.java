package com.changke.coursemanagementsystem.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnLineListener
 *
 */
@WebListener
public class OnLineListener implements HttpSessionListener {
	private int onLine = 0;

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		onLine++;
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("onLine", onLine);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		onLine--;
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("onLine", onLine);
	}

}
