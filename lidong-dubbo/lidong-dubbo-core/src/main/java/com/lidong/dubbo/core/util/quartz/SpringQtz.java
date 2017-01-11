package com.lidong.dubbo.core.util.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SpringQtz  {  
	
	static Logger  logger = LoggerFactory.getLogger(SpringQtz.class);
	private static int counter = 0;  
    public   void execute()  {
        long ms = System.currentTimeMillis();  
        logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(ms))+"  "+"(" + counter++ + ")");  
    }  
}  