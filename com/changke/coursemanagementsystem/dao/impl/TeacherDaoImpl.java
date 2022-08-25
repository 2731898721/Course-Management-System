package com.changke.coursemanagementsystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.changke.selectclasssystem.dao.TeacherDao;
import com.changke.selectclasssystem.model.Course;
import com.changke.selectclasssystem.model.Teacher;
import com.changke.selectclasssystem.tools.DBUtils;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public List<Teacher> select() {
		List<Teacher> list = new ArrayList<Teacher>();
		DBUtils instence = DBUtils.getInstence();
		String sql = "select * from teacher where delflag = 0";
		ResultSet rs = instence.query(sql);
		try {
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				t.setBirthday(rs.getString("birthday"));
				t.setNote(rs.getString("note"));
				t.setSex(rs.getString("sex"));
				t.setTheOnlyNumber(rs.getInt("TheOnlyNumber"));
				t.setTel(rs.getString("tel"));
				t.setDelflag(rs.getInt("delflag"));
				t.setOfficetime(rs.getString("officetime"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return list;
	}

	@Override
	public int add(Teacher t) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "insert into teacher (tname,tel,birthday,sex,officetime,note,TheOnlyNumber) values(?,?,?,?,?,?,?)";
		Object[] obj = new Object[] { t.getTname(), t.getTel(), t.getBirthday(), t.getSex(), t.getOfficetime(),
				t.getNote(), t.getTheOnlyNumber() };
		return instence.updata(sql, obj);
	}

//select * FROM  (select course.*,teacher.tname,teacher.tel from course LEFT JOIN teacher on course.tid = teacher.tid )as tea_c WHERE tid = 1
	@Override
	public List<Course> look(String id) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		List<Course> list = new ArrayList<Course>();
		String sql = "select * FROM  (select course.*,teacher.tname,teacher.tel from course LEFT JOIN teacher on course.tid = teacher.tid )as tea_c WHERE tid = ?";
		ResultSet rs = instence.query(sql, id);
		while (rs.next()) {
			Course c = new Course(rs.getString("num"), rs.getString("className"), rs.getString("score"),
					rs.getString("begintime"), rs.getString("endtime"));
			list.add(c);
		}
		return list;
	}
}
