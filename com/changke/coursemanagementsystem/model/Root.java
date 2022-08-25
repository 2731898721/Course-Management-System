package com.changke.coursemanagementsystem.model;

public class Root {
	private int id;
	private String name;
	private String username;
	private String password;
	private String ip;
	private String sex;
	private String tel;
	private String email;
	private String info;
	private int delflag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Root() {

	}

	public Root(String name, String username, String password, String ip, String sex, String tel, String email,
			String info) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.info = info;
	}

}
