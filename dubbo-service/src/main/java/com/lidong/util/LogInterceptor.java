package com.lidong.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * joinPoint
 * @author Administrator
 *execution(* com.lidong.*.controller.*.*(..))"
 */
@Aspect
@Component
public class LogInterceptor {

	
	@Pointcut("execution (* com.lidong.*.controller.*.*(..))")  
    private void aspectjMethod() {  
    };
	
	
    @Before("aspectjMethod()")  
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {  
        System.out.println("@Before");
    }  
    
    @AfterReturning(value = "aspectjMethod()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "aspectjMethod()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("@AfterThrowing");
    }
  
    
    @After("aspectjMethod()")   
    public void doAfterInServiceLayer(JoinPoint joinPoint) {  
    	  System.out.println("@After");  
    }  
  
   
  
}
