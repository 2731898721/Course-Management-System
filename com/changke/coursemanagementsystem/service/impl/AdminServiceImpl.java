package com.changke.coursemanagementsystem.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.dao.AdminDao;
import com.changke.selectclasssystem.dao.impl.AdminDaoImpl;
import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = new AdminDaoImpl();

	@Override
	public void add(Root r, HttpServletResponse response) throws Exception {
		int i = dao.add(r);
		if (i != 0) {
			response.sendRedirect("/selectingcourses/successPages/success.jsp");

		}
		if (i == 0) {
			response.sendRedirect("/selectingcourses/errorPages/error.jsp");
		}

	}

}
