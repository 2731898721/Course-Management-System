package com.changke.coursemanagementsystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Student;

public interface StudentService {

	void select(HttpServletRequest request, HttpServletResponse response, String clazz, String name, String cId)
			throws Exception;

	void del(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	void update(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	void realUpdate(Student s, HttpServletRequest request, HttpServletResponse response) throws Exception;

	void add(Student student, HttpServletResponse response) throws Exception;

	void find(HttpServletRequest request, HttpServletResponse response) throws Exception;

	void selected(String[] selects, String id, HttpServletResponse response, HttpServletRequest request)
			throws Exception;

	void cancel(String id, String cid, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
