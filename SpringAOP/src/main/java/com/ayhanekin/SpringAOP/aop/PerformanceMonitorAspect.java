package com.ayhanekin.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);


    @Around("execution(* com.ayhanekin.SpringAOP.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed(); // This method will call the method we have specified at the point cut and return object because of object we ar going to take result
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken :{} ms and the method is {}", (end - start),joinPoint.getSignature().getName());
        return object;
    }

}
