package com.changke.coursemanagementsystem.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.changke.selectclasssystem.dao.ClassDao;
import com.changke.selectclasssystem.dao.StudentDao;
import com.changke.selectclasssystem.dao.impl.ClassDaoImpl;
import com.changke.selectclasssystem.dao.impl.StudentDaoImpl;
import com.changke.selectclasssystem.model.Clazz;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao = new StudentDaoImpl();
	private ClassDao classDao = new ClassDaoImpl(); // 属于逻辑问题，没办法才写到这里的

	@Override
	public void del(String id, HttpServletRequest request, HttpServletResponse response) {

		int i;
		try {
			i = dao.del(id);
			if (i > 0) {
				response.sendRedirect("/selectingcourses/successPages/delSuccess.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Student student = dao.update(id);
		if (student != null) {
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			response.sendRedirect("student/studentUpdateInfo.jsp");
		}
	}

	@Override
	public void realUpdate(Student s, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int i = dao.realUpdate(s);
		if (i > 0) {
			response.sendRedirect("/selectingcourses/successPages/updateSuccess.jsp");
		}

	}

	@Override
	public void add(Student student, HttpServletResponse response) throws Exception {
		int i = dao.add(student);
		if (i > 0) {
			response.sendRedirect("/selectingcourses/successPages/studentAddsuccess.jsp");
		}
	}

	@Override
	public void find(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Course> list = dao.find();
		if (list != null) {
			HttpSession session = request.getSession();
			System.out.println(list);
			session.setAttribute("listclass", list);
			request.getRequestDispatcher("/course/courseList.jsp").forward(request, response);
		}
	}

	@Override
	public void select(HttpServletRequest request, HttpServletResponse response, String clazz, String name, String cid)
			throws Exception {
		List<Student> list = dao.list(clazz, name, cid);
		List<Clazz> queryClass = classDao.queryClass();
		if (list != null) {
			HttpSession session = request.getSession();
			session.setAttribute("listAll", list);
			request.setAttribute("name", name);
			request.setAttribute("kecheng", clazz);
			request.setAttribute("cid", cid);
			request.setAttribute("queryClass", queryClass);
			request.getRequestDispatcher("student/studentList.jsp").forward(request, response);
		}
	}

	@Override
	public void selected(String[] selects, String id, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		int i = dao.mySelected(selects, id);
		if (i > 0) {
			response.sendRedirect("successPages/studentAddsuccess.jsp");
		}

	}

	@Override
	public void cancel(String id, String cid, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int i = dao.cancelC(id, cid);
		if (i > 0) {
			response.sendRedirect("successPages/delSuccess.jsp");
//			PrintWriter out = response.getWriter();
//			System.out.println(id);
//			out.write("<script>alert('******取消课程成功******')</script>");
//			response.sendRedirect("common/right.html");
		}
	}
}
