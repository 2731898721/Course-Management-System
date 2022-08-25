package com.changke.coursemanagementsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.changke.selectclasssystem.dao.StudentDao;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Student;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.tools.DBUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int del(String id) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "update student  set delflag= '1' where id= ?";
		return instence.updata(sql, id);
	}

	@Override
	public Student update(String id) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "select * from student where id= ?";
		ResultSet rs = instence.query(sql, id);
		if (rs.next()) {
			Student student = new Student();
			student.setCourse(rs.getString("course"));
			student.setBirthday(rs.getString("birthday"));
			student.setGrade(rs.getString("grade"));
			student.setName(rs.getString("name"));
			student.setNumber(rs.getString("number"));
			student.setSex(rs.getString("sex"));
			student.setTname(rs.getString("tname"));
			student.setTid(rs.getInt("tid"));
			student.setId(rs.getInt("id"));
			return student;
		}
		return null;
	}

	@Override
	public int realUpdate(Student s) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "update student  set name=?,birthday=?,grade=?,course=? where id= ?";
		return instence.updata(sql, s.getName(), s.getBirthday(), s.getGrade(), s.getCourse(), s.getId());
	}

	@Override
	public int add(Student student) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "insert into student values(null,?,?,?,?,?,?,?,0,?,0);";
		Object[] temp = new Object[] { student.getName(), student.getNumber(), student.getSex(), student.getTel(),
				student.getGrade(), student.getCourse(), student.getTname(), student.getBirthday() };
		return instence.updata(sql, temp);
	}

	@Override
	public List<Course> find() throws Exception {
		List<Course> list = new ArrayList<Course>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		ResultSet rs = null;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/changke?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8",
				"root", "898721");
		String sql = "select course.*,teacher.tname,teacher.tid,teacher.tel from course LEFT JOIN teacher on course.tid=teacher.tid";
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTel(rs.getString("tel"));
			teacher.setTname(rs.getString("tname"));
			teacher.setTid(rs.getInt("tid"));
			Course c = new Course(rs.getInt("cid"), rs.getString("num"), rs.getString("className"),
					rs.getString("score"), rs.getString("begintime"), rs.getString("endtime"), teacher);
			list.add(c);
		}
		return list;
	}

	@Override
	public List<Student> list(String clazz, String name, String cid) throws Exception {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student where delflag = 0 and 1=1 ";
		if (name != null && !"".equals(name)) {
			sql += "and name like '%" + name + "%' ";
		}
		if (clazz != null && !"".equals(clazz)) {
			sql += "and course = '" + clazz + "'  ";
		}
		if (!"-1".equals(cid) && cid != null) {
			sql += " and cid  = " + cid + "";
		}
		DBUtils instence = DBUtils.getInstence();
		ResultSet rs = instence.query(sql);
		while (rs.next()) {
			Student student = new Student();
			student.setCourse(rs.getString("course"));
			student.setBirthday(rs.getString("birthday"));
			student.setGrade(rs.getString("grade"));
			student.setName(rs.getString("name"));
			student.setNumber(rs.getString("number"));
			student.setSex(rs.getString("sex"));
			student.setTname(rs.getString("tname"));
			student.setTid(rs.getInt("tid"));
			student.setId(rs.getInt("id"));
			student.setCid(rs.getInt("cid"));
			list.add(student);
		}
		return list;
	}

	// SELECT * from (select student.name,student.id ,studnet_course.cid FROM
	// `studnet_course` LEFT JOIN student on studnet_course.id = student.id and
	// studnet_course.id = 1) as a LEFT JOIN course on a.cid = course.cid and id =1
	@Override
	public int mySelected(String[] selects, String sid) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		for (int i = 0; i < selects.length; i++) {
//		休息一下马上回来  ！！	String sql = "insert into studnet_course(id,cid,flag) values(?,?,1);";
	//		instence.updata(sql, sid, selects[i]);
		}
		return 1;
	}

	@Override
	public int cancelC(String id, String cid) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "delete from studnet_course WHERE  id = ? and cid = ?";
		return instence.updata(sql, id, cid);
	}
}
