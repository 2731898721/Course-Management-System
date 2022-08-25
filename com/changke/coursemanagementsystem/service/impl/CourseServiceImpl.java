package com.changke.coursemanagementsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changke.selectclasssystem.dao.CourseDao;
import com.changke.selectclasssystem.dao.impl.CourseDaoImpl;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao dao = new CourseDaoImpl();

	@Override
	public void add(Course c, HttpServletResponse response) throws Exception {
		int i = dao.add(c);
		if (i > 0) {
			response.sendRedirect("common/right.html");
		}
	}

	@Override
	public void give(String cid, String tid, HttpServletResponse response) throws Exception {
		int i = dao.give(cid, tid);
		if (i > 0) {
			System.out.println("success");
			response.sendRedirect("successPages/loading.jsp");
		}

	}

	@Override
	public void getInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Course> list = dao.getInfo();
		if (list != null) {
			HttpSession session = request.getSession();
			session.setAttribute("info", list);
			response.sendRedirect("student/courseSelectList.jsp");

		}
	}

	@Override
	public void checked(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Course> list = dao.checked(id);
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/student/courseSelectedList.jsp").forward(request, response);
		}
	}

}
