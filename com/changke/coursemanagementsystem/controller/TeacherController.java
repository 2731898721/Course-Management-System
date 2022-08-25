package com.changke.coursemanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.service.TeacherService;
import com.changke.selectclasssystem.service.impl.TeacherServiceImpl;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService service = new TeacherServiceImpl();

	public TeacherController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String flag = request.getParameter("flag");

		if ("null".equals(flag)) {
			try {
				service.select(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("del".equals(flag)) {
			System.out.println("删除");
		}
		if ("update".equals(flag)) {
			System.out.println("修改");
		}
		if ("addTeacher".equals(flag)) {
			String num = request.getParameter("num");
			String note = request.getParameter("remark");
			String date = request.getParameter("date"); // 入职日志
			String phone = request.getParameter("phone");
			String birthDay = request.getParameter("birthday");
			String sex = request.getParameter("sex");
			String name = request.getParameter("name");
			Teacher t = new Teacher(name, phone, birthDay, date, sex, note, Integer.parseInt(num));
			try {
				service.addTeacher(t, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if ("look".equals(flag)) {
			String id = request.getParameter("tid");
			try {
				service.look(id, response, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
