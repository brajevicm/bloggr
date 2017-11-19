package com.brajevicm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@Aspect
public class BlogServiceLogger {
  final static Logger logger = LoggerFactory.getLogger(BlogServiceLogger.class);

  @Pointcut("execution(* com.brajevicm.service.BlogService.create(..))")
  public void create() {
  }

  @Before("create()")
  public void beforeSave() {
    logger.info("Creating blog...");
  }

  @After("create()")
  public void afterSave(JoinPoint joinPoint) {
    logger.info("Success on: " + joinPoint.getSignature().getName());
  }

  @AfterThrowing(value = "create()", throwing = "error")
  public void afterSave(JoinPoint joinPoint, Throwable error) {
    logger.info("Failure on: " + joinPoint.getSignature().getName());
    logger.error(error.toString());
  }

  @Around("create()")
  public void aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Creating blog started...");
    joinPoint.proceed();
    logger.info("Creating blog finished...");
  }

}

