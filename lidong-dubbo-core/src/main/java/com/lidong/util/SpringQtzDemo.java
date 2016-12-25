package com.lidong.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SpringQtzDemo {

	static Logger logger = LoggerFactory.getLogger(SpringQtzDemo.class);
	private static int counter = 0;

	protected void work() {
		long ms = System.currentTimeMillis();
		logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date(ms)) + "  " + "任务调度    (" + counter++ + ")");

	}

}
