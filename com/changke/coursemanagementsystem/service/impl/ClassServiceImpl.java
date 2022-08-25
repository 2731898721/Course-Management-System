package com.changke.coursemanagementsystem.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.changke.selectclasssystem.dao.ClassDao;
import com.changke.selectclasssystem.dao.impl.ClassDaoImpl;
import com.changke.selectclasssystem.model.Clazz;
import com.changke.selectclasssystem.service.ClassService;

public class ClassServiceImpl implements ClassService {
	private ClassDao dao = new ClassDaoImpl();

	@Override
	public void classList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Clazz> list = dao.queryClass();
		System.out.println(list);
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/student/studentList.jsp").forward(request, response);
		}
	}



}
