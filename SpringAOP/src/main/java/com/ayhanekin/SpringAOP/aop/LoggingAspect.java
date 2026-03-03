package com.ayhanekin.SpringAOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)

    @Before("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..)) || execution(* com.ayhanekin.SpringAOP.service.JobService.getAllJobs(..))")
    public void logMethodCalled(JoinPoint joinPoint){
        LOGGER.info("Method has been called...{}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..)) || execution(* com.ayhanekin.SpringAOP.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method has been executed...{}", joinPoint.getSignature().getName());
    }
}
