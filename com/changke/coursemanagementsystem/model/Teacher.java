package com.changke.coursemanagementsystem.model;

public class Teacher {
	private int tid;
	private String tname;
	private String tel;
	private String birthday;
	private String officetime;
	private String sex;
	private String note;
	private int theOnlyNumber;
	private int delflag;

	public Teacher(String tname, String tel, String birthday, String officetime, String sex, String note,
			int theOnlyNumber) {
		super();
		this.tname = tname;
		this.tel = tel;
		this.birthday = birthday;
		this.officetime = officetime;
		this.sex = sex;
		this.note = note;
		this.theOnlyNumber = theOnlyNumber;
	}

	public String getOfficetime() {
		return officetime;
	}

	public void setOfficetime(String officetime) {
		this.officetime = officetime;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTheOnlyNumber() {
		return theOnlyNumber;
	}

	public void setTheOnlyNumber(int theOnlyNumber) {
		this.theOnlyNumber = theOnlyNumber;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public Teacher() {
		super();
	}

}
