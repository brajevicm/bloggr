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

  @Pointcut("execution(* com.brajevicm.repository.BlogRepository.save(..))")
  public void save() {
  }

  @Before("save()")
  public void beforeSave() {
    logger.info("Saving blog...");
  }

  @After("save()")
  public void afterSave(JoinPoint joinPoint) {
    logger.info("Success on: " + joinPoint.getSignature().getName());
  }

  @AfterThrowing(value = "save()", throwing = "error")
  public void afterSave(JoinPoint joinPoint, Throwable error) {
    logger.info("Failure on: " + joinPoint.getSignature().getName());
    logger.error(error.toString());
  }

  @Around("save()")
  public void aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Saving blog started...");
    joinPoint.proceed();
    logger.info("Saving blog finished...");
  }

}

