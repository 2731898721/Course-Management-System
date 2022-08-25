package com.changke.coursemanagementsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.changke.selectclasssystem.dao.TeacherDao;
import com.changke.selectclasssystem.dao.impl.TeacherDaoImpl;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao dao = new TeacherDaoImpl();

	@Override
	public void select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Teacher> list = dao.select();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/teacher/teacherList.jsp").forward(request, response);
		}
	}

	@Override
	public void addTeacher(Teacher t, HttpServletResponse response) throws Exception {
		int i = dao.add(t);
		if (i > 0) {
			response.sendRedirect("common/right.html");
		}

	}

	@Override
	public void look(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
		List<Course> list = dao.look(id);
		request.setAttribute("tea_class", list);
		request.getRequestDispatcher("/teacher/scheduleList.jsp").forward(request, response);
	}

}
