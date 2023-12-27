package com.arnovandijck.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("execution(* com.arnovandijck.learnspringaop.aopexample.*.*.*(..))")
    @Around("com.arnovandijck.learnspringaop.aopexample.aspects.CommonPointcutsConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        // Start the timer
        long startTimeMillis = System.currentTimeMillis();

        // Execute the method
        Object returnValue = pjp.proceed(); // This is the method that is being intercepted

        // Stop the timer
        long endTimeMillis = System.currentTimeMillis();
        long executionTimeMillis = endTimeMillis - startTimeMillis;
        logger.info("Around Aspect - {} Method executed in {} ms", pjp ,executionTimeMillis);

        return returnValue;
    }
}
