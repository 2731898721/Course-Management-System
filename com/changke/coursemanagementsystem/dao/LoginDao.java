package com.changke.coursemanagementsystem.dao;

import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.model.Teacher;

public interface LoginDao {

	Root select(Root root) throws Exception;

	Teacher selectTeacher(Root root) throws Exception;

	Student selectStudent(Root root) throws Exception;

}
