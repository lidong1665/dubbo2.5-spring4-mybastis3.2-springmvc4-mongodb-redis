package com.lidong.dubbo.util;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称:lidong-dubbo
 * @类名:WebLogAspect
 * @类的描述:保存请求数据到mongodb
 * @作者:lidong
 * @创建时间:2017/1/9 上午9:59
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Aspect
@Component
public class WebLogAspect{

    private Logger logger = Logger.getLogger("mongodb");
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    HttpServletRequest request;
    JoinPoint mJoinPoint;
	@Pointcut("execution (* com.lidong.dubbo.*.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	    startTime.set(System.currentTimeMillis());   
       	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        request = attributes.getRequest();
        mJoinPoint = joinPoint;
    }


    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {
        BasicDBObject r = new BasicDBObject();
        r.append("requestURL", request.getRequestURL().toString());
        r.append("requestURI", request.getRequestURI());
        r.append("queryString", request.getQueryString());
        r.append("remoteAddr", request.getRemoteAddr());
        r.append("remoteHost", request.getRemoteHost());
        r.append("remotePort", request.getRemotePort());
        r.append("localAddr", request.getLocalAddr());
        r.append("localName", request.getLocalName());
        r.append("method", request.getMethod());
        r.append("headers", getHeadersInfo(request));
        r.append("parameters", request.getParameterMap());
        r.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.append("args", Arrays.toString(joinPoint.getArgs()));
        return r;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String,String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
    	     BasicDBObject logInfo;
        logInfo = getBasicDBObject(request, mJoinPoint);
        // 处理完请求，返回内容
    	     logInfo.append("response",ret);
    	     logInfo.append("spend_time", (System.currentTimeMillis() - startTime.get()));
    	     logger.info(logInfo);
     }
}