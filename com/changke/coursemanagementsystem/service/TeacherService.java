package com.changke.coursemanagementsystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Teacher;

public interface TeacherService {

	void select(HttpServletRequest request, HttpServletResponse response) throws Exception;

	void addTeacher(Teacher t, HttpServletResponse response) throws Exception;

	void look(String id, HttpServletResponse response, HttpServletRequest request) throws Exception;
}
