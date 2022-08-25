package com.changke.coursemanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.service.AdminService;
import com.changke.selectclasssystem.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String name = request.getParameter("name");
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String info = request.getParameter("info");
		String ip = request.getRemoteAddr();

		Root r = new Root(name, adminUsername, adminPassword, ip, sex, tel, email, info);
		try {
			service.add(r, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
