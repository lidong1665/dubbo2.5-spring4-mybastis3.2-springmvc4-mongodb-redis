package com.lidong.dubbo.core.util.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

public class MyDetailQuartzJobBean extends QuartzJobBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());



    private String targetObject;

    private String targetMethod;

    private ApplicationContext ctx;



    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        try {



            logger.info("execute [" + targetObject + "] at once>>>>>>");

            Object otargetObject = ctx.getBean(targetObject);

            Method m = null;

            try {

                m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});



                m.invoke(otargetObject, new Object[] {});

            } catch (SecurityException e) {

                logger.error("异常",e);

            } catch (NoSuchMethodException e) {

                logger.error("异常",e);

            }



        } catch (Exception e) {

            throw new JobExecutionException(e);

        }



    }



    public void setApplicationContext(ApplicationContext applicationContext) {

        this.ctx = applicationContext;

    }



    public void setTargetObject(String targetObject) {

        this.targetObject = targetObject;

    }



    public void setTargetMethod(String targetMethod) {

        this.targetMethod = targetMethod;

    }



}
