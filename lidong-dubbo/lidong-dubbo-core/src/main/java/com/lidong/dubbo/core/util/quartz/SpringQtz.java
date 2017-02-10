package com.lidong.dubbo.core.util.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @项目名称:lidong-dubbo
 * @类名:SpringQtz
 * @类的描述: 作业类的调度
 * @作者:lidong
 * @创建时间:2017/2/8 下午5:41
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public class SpringQtz  {  
	
	static Logger  logger = LoggerFactory.getLogger(SpringQtz.class);
	private static int counter = 0;

    /**
     * 调度的方法
     */
    public   void execute()  {
        long ms = System.currentTimeMillis();  
        logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(ms))+"  "+"(" + counter++ + ")");  
    }  
}  