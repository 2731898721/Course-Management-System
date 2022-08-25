package com.changke.coursemanagementsystem.model;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cid;
	private String num;
	private String className;
	private String score;
	private String begintime;
	private String endtime;
	private int delflag;
	private int tid;
	private Teacher teacher;

	public Course(String num, String className, String score, String begintime, String endtime, int tid) {
		super();
		this.num = num;
		this.className = className;
		this.score = score;
		this.begintime = begintime;
		this.endtime = endtime;
		this.tid = tid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Course(int cid, String num, String className, String score, String begintime, String endtime,
			Teacher teacher) {
		super();
		this.cid = cid;
		this.num = num;
		this.className = className;
		this.score = score;
		this.begintime = begintime;
		this.endtime = endtime;
		this.teacher = teacher;
	}

	public Course(String num, String className, String score, String begintime, String endtime, Teacher teacher) {
		super();
		this.num = num;
		this.className = className;
		this.score = score;
		this.begintime = begintime;
		this.endtime = endtime;
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public Course(String num, String className, String score, String begintime, String endtime) {
		super();
		this.num = num;
		this.className = className;
		this.score = score;
		this.begintime = begintime;
		this.endtime = endtime;
	}

	public Course() {
	}

}
