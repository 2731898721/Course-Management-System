package com.changke.coursemanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.service.StudentService;
import com.changke.selectclasssystem.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
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

		String flag = request.getParameter("flag");
		if (flag == null) {
			String clazz = request.getParameter("clazz");
			String name = request.getParameter("name");
			String cId = request.getParameter("banji");
			if (clazz != null) {
				clazz = clazz.trim();
			}
			if (name != null) {
				name = name.trim();
			}
			try {
				service.select(request, response, clazz, name, cId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("del".equals(flag)) {
			String id = request.getParameter("id");
			try {
				service.del(id, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("update".equals(flag)) {
			String id = request.getParameter("id");
			try {
				service.update(id, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("real".equals(flag)) {
			String name = request.getParameter("name");
			String banji = request.getParameter("banji");
			String kecheng = request.getParameter("kecheng");
			String birthday = request.getParameter("birthday");
			String id = request.getParameter("id");

			Student s = new Student();
			s.setName(name);
			s.setBirthday(birthday);
			s.setCourse(kecheng);
			s.setGrade(banji);
			s.setId(Integer.parseInt(id));

			try {
				service.realUpdate(s, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("add".equals(flag)) {
			String name = request.getParameter("name");
			String number = request.getParameter("pwd");
			String tel = request.getParameter("tel");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String teacher = request.getParameter("teacher");
			String banji = request.getParameter("class");
			String kecheng = request.getParameter("kecheng");

			Student student = new Student(name, number, sex, birthday, banji, kecheng, tel, teacher);
			try {
				service.add(student, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if ("selectCourse".equals(flag)) {
			try {
				service.find(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("quxiao".equals(flag)) {
			String id = request.getParameter("id");
			System.out.println("----" + id);
		}
		if ("xiugai".equals(flag)) {
			System.err.println("=====");
		}
		if ("selected".equals(flag)) {
			String id = request.getParameter("id");
			String[] selects = request.getParameterValues("checked");
			try {
				service.selected(selects, id, response, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("cancel".equals(flag)) {
			String cid = request.getParameter("cid");
			HttpSession session = request.getSession();
			Student s = (Student) session.getAttribute("student");
			String id = String.valueOf(s.getId());
			try {
				service.cancel(id, cid, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
