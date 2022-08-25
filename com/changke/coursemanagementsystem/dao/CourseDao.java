package com.changke.coursemanagementsystem.dao;

import java.util.List;

import com.changke.selectclasssystem.model.Course;

public interface CourseDao {

	int add(Course c) throws Exception;

	int give(String cid, String tid) throws Exception;

	List<Course> getInfo() throws Exception;

	List<Course> checked(String id) throws Exception;

}
