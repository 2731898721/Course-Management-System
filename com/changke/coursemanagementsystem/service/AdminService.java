package com.changke.coursemanagementsystem.service;

import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Root;

public interface AdminService {

	void add(Root r, HttpServletResponse response) throws Exception;

}
