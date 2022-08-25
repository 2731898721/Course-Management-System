package com.changke.coursemanagementsystem.dao.impl;

import com.changke.selectclasssystem.dao.AdminDao;
import com.changke.selectclasssystem.model.Root;
import com.changke.selectclasssystem.tools.DBUtils;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int add(Root r) throws Exception {
		DBUtils instence = DBUtils.getInstence();
		String sql = "insert into root (name,username,password,sex,ip,tel,email,info) values(?,?,?,?,?,?,?,?)";
		return instence.updata(sql, r.getName(), r.getUsername(), r.getPassword(), r.getSex(), r.getIp(), r.getTel(),
				r.getEmail(), r.getInfo());

	}

}
