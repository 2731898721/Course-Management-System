package com.changke.coursemanagementsystem.service.impl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changke.selectclasssystem.dao.LoginDao;
import com.changke.selectclasssystem.dao.impl.LoginDaoImpl;
import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private LoginDao dao = new LoginDaoImpl();

	@Override
	public void login(Root root, String role, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		if ("admin".equals(role)) {
			Root r = dao.select(root);
			if (r != null) {
				HttpSession session = request.getSession();
				session.setAttribute("root", r);
				session.setAttribute("role", role);
				response.sendRedirect("common/index.jsp");
				ServletContext i = request.getServletContext();
				Integer count1 = (Integer) i.getAttribute("count");
				if (count1 == null) {
					count1 = 1;
				} else {
					count1++;
				}
				i.setAttribute("count", count1);

			}
			if (r == null) {
				request.setAttribute("error", "❌");
				request.getRequestDispatcher("common/login.jsp").forward(request, response);

			}

		}
		if ("teacher".equals(role)) {
			Teacher teacher = dao.selectTeacher(root);
			if (teacher != null) {
				HttpSession session = request.getSession();
				session.setAttribute("teacher", teacher);
				session.setAttribute("role", role);
				response.sendRedirect("common/index.jsp"); // 结束资源，filter结束
			}
			if (teacher == null) {
				request.setAttribute("error", "❌");
				request.getRequestDispatcher("common/login.jsp").forward(request, response);
			}

		}
		if ("student".equals(role)) {
			Student s = dao.selectStudent(root);
			if (s != null) {
				HttpSession session = request.getSession();
				session.setAttribute("student", s);
				session.setAttribute("role", role);
				response.sendRedirect("common/index.jsp");
			}
			if (s == null) {
				request.setAttribute("error", "❌");
				request.getRequestDispatcher("common/login.jsp").forward(request, response);
			}

		}
	}

}
