package com.ayhanekin.SpringAOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
!!! AOP only works for external method calls that pass through the proxy.
*/

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

    @AfterThrowing("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..)) || execution(* com.ayhanekin.SpringAOP.service.JobService.getAllJobs(..))")
    public void logMethodCrashed(JoinPoint joinPoint){
        LOGGER.info("Method has been crashed...{}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..)) || execution(* com.ayhanekin.SpringAOP.service.JobService.getAllJobs(..))")
    public void logMethodWorkedSuccessfully(JoinPoint joinPoint){
        LOGGER.info("Method has been worked successfully...{}", joinPoint.getSignature().getName());
    }

}
