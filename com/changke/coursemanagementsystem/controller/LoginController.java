package com.changke.coursemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.service.LoginService;
import com.changke.selectclasssystem.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService service = new LoginServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(username + "--******--" + password);
		String random = request.getParameter("random");
		String randStr = (String) request.getSession().getAttribute("randStr");

		if (!random.equals(randStr)) {
			request.setAttribute("error", "❌");
			request.setAttribute("random", random);
			request.getRequestDispatcher("common/login.jsp").forward(request, response);
			return;
		}

		if ("" != username || "" != password || role != null)

		{

			try {
				Root root = new Root();
				root.setUsername(username);
				root.setPassword(password);
				service.login(root, role, response, request);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (username == "" || "" == password || role == null) {
			request.getRequestDispatcher("common/login.jsp").forward(request, response);

		}

	}

}
