package com.changke.coursemanagementsystem.dao;

import java.util.List;

import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Student;

public interface StudentDao {

	List<Student> list(String clazz, String name, String cid) throws Exception;

	int del(String id) throws Exception;

	Student update(String id) throws Exception;

	int realUpdate(Student s) throws Exception;

	int add(Student student) throws Exception;

	List<Course> find() throws Exception;

	int mySelected(String[] selects, String sid) throws Exception;

	int cancelC(String cid, String id) throws Exception;

}
