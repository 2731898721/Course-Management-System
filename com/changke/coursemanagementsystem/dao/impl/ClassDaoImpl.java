package com.changke.coursemanagementsystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.changke.selectclasssystem.dao.ClassDao;
import com.changke.selectclasssystem.model.Clazz;
import com.changke.selectclasssystem.tools.DBUtils;

public class ClassDaoImpl implements ClassDao {

	@Override
	public List<Clazz> queryClass() throws SQLException {
		List<Clazz> list = new ArrayList<Clazz>();
		DBUtils db = DBUtils.getInstence();
		String sql = "select * from class";
		ResultSet rs = db.query(sql);
		while (rs.next()) {
			Clazz c = new Clazz();
			c.setCid(rs.getString("cid"));
			c.setCname(rs.getString("cname"));
			c.setTid(rs.getInt("tid"));
			list.add(c);
		}
		return list;
	}

}
