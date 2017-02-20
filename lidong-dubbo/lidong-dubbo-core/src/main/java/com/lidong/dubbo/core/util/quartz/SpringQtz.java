package com.lidong.dubbo.core.util.quartz;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;

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

public class SpringQtz extends QuartzJobBean{


    static Logger  logger = LoggerFactory.getLogger(SpringQtz.class);

    private static int counter = 0;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        long ms = System.currentTimeMillis();
        logger.error(" SpringQtz start  执行");
        logger.info("-------"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(ms))+"  "+"(" + counter++ + ")");
    }

}