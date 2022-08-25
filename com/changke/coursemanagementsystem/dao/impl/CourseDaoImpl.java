package com.changke.coursemanagementsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.changke.selectclasssystem.dao.CourseDao;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.tools.DBUtils;

public class CourseDaoImpl implements CourseDao {

	@Override
	public int add(Course c) {
		DBUtils instence = DBUtils.getInstence();
		String sql = "insert into course(num,className,score,begintime,endtime,tid) values(?,?,?,?,?,?)";
		Object[] obj = new Object[] { c.getNum(), c.getClassName(), c.getScore(), c.getBegintime(), c.getEndtime(),
				c.getTid() };
		return instence.updata(sql, obj);
	}

	@Override
	public int give(String cid, String tid) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "insert into course_teacher(cid,tid) values(?,?)";
		return instence.updata(sql, cid, tid);
	}

	@Override
	public List<Course> getInfo() throws Exception {
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
	public List<Course> checked(String id) throws Exception {
		List<Course> list = new ArrayList<Course>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		ResultSet rs = null;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/changke?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8",
				"root", "898721");
		String sql = "select * from (select * from (SELECT studnet_course.id,course.className,course.begintime,course.endtime,course.num,course.score,course.cid from studnet_course LEFT JOIN course on studnet_course.cid = course.cid) as a WHERE id =?)as b LEFT JOIN teacher on b.cid = teacher.cid";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
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
}
