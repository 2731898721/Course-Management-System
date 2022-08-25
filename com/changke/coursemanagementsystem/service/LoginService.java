package com.changke.coursemanagementsystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changke.selectclasssystem.model.Root;

public interface LoginService {

	void login(Root root, String role, HttpServletResponse response, HttpServletRequest request) throws Exception;

}
