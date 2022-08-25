package com.changke.coursemanagementsystem.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Time extends TimerTask {

	@Override
	public void run() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	}

}
