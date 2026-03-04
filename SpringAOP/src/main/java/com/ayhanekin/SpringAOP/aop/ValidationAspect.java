package com.ayhanekin.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..)) && args (postId)")
    public Object jobUrlValidation (ProceedingJoinPoint joinPoint, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.info("postId is negative updating it...");
            postId = -postId;
            LOGGER.info("postId is updated new value is {}...",postId);
        }

        return joinPoint.proceed(new Object[]{postId});
    }
}
