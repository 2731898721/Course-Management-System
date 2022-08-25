package com.changke.coursemanagementsystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.changke.selectclasssystem.model.Course;

public interface CourseService {
	void add(Course c, HttpServletResponse response) throws Exception;

	void give(String cid, String tid, HttpServletResponse response) throws Exception;

	void getInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

	void checked(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}