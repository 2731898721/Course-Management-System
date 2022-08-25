package com.changke.coursemanagementsystem.dao.impl;

import java.sql.ResultSet;
import com.changke.selectclasssystem.dao.LoginDao;
import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.tools.DBUtils;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Root select(Root root) throws Exception {
		DBUtils dao = DBUtils.getInstence();
		String sql = "select * from root where password=? and username=?";
		ResultSet rs = dao.query(sql, root.getPassword(), root.getUsername());
		if (rs.next()) {
			Root r = new Root();
			r.setId(rs.getInt("id"));
			r.setDelflag(rs.getInt("delflag"));
			r.setName(rs.getString("name"));
			r.setPassword(rs.getString("password"));
			r.setUsername(rs.getString("username"));
			r.setIp(rs.getString("ip"));
			r.setEmail(rs.getString("email"));
			r.setInfo(rs.getString("info"));
			r.setTel(rs.getString("tel"));
			r.setSex(rs.getString("sex"));
			return r;
		}
		return null;
	}

	@Override
	public Teacher selectTeacher(Root root) throws Exception {
		DBUtils dao = DBUtils.getInstence();
		String sql = "select * from teacher where tel=? and TheOnlyNumber=?";
		ResultSet rs = dao.query(sql, root.getPassword(), root.getUsername());
		if (rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTid(rs.getInt("tid"));
			teacher.setDelflag(rs.getInt("delflag"));
			teacher.setTname(rs.getString("tname"));
			teacher.setSex(rs.getString("sex"));
			teacher.setTel(rs.getString("tel"));
			teacher.setOfficetime(rs.getString("officetime"));
			teacher.setNote(rs.getString("note"));
			teacher.setBirthday(rs.getString("birthday"));
			teacher.setTheOnlyNumber(rs.getInt("TheOnlyNumber"));
			return teacher;
		}
		return null;
	}

	@Override
	public Student selectStudent(Root root) throws Exception {
		DBUtils dao = DBUtils.getInstence();
		String sql = "select * from student where id=? and number=?";
		ResultSet rs = dao.query(sql, root.getPassword(), root.getUsername());
		if (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setDelflag(rs.getInt("delflag"));
			student.setNumber(rs.getString("number"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setTel(rs.getString("tel"));
			student.setGrade(rs.getString("grade"));
			student.setCourse(rs.getString("course"));
			student.setBirthday(rs.getString("birthday"));
			student.setTid(rs.getInt("tid"));
			return student;
		}
		return null;
	}
}
