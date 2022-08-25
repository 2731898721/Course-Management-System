package com.changke.coursemanagementsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.service.CourseService;
import com.changke.selectclasssystem.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService service = new CourseServiceImpl();

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
		if ("add".equals(flag)) {
			String teaId = request.getParameter("tea");
			String endTime = request.getParameter("endtime");
			String beginTime = request.getParameter("begintime");
			String score = request.getParameter("score");
			String num = request.getParameter("num");
			String className = request.getParameter("classname");
			Course c = new Course(num, className, score, beginTime, endTime, Integer.parseInt(teaId));
			try {
				service.add(c, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("Grant".equals(flag)) {
			String cid = request.getParameter("select1");
			String tid = request.getParameter("select2");
			try {
				service.give(cid, tid, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("info".equals(flag)) {
			try {
				service.getInfo(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("checked".equals(flag)) {
			try {
				String id = request.getParameter("id");
				service.checked(id, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
