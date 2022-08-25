package com.changke.coursemanagementsystem.dao;

import java.util.List;

import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Teacher;

public interface TeacherDao {

	List<Teacher> select() throws Exception;

	int add(Teacher t) throws Exception;

	List<Course> look(String id) throws Exception;

}
