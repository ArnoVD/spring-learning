package com.arnovandijck.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogginAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut expression that matches all methods in the package com.arnovandijck.learnspringaop.aopexample.business
    // @Before intercepts all method calls that match the pointcut expression
    @Before("com.arnovandijck.learnspringaop.aopexample.aspects.CommonPointcutsConfig.aopExamplePackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with arguments {}", joinPoint, joinPoint.getArgs());
    }

    // @After intercepts all method calls that match the pointcut expression
    @After("com.arnovandijck.learnspringaop.aopexample.aspects.CommonPointcutsConfig.aopExamplePackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.arnovandijck.learnspringaop.aopexample.aspects.CommonPointcutsConfig.businessPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspects - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.arnovandijck.learnspringaop.aopexample.aspects.CommonPointcutsConfig.allServiceConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccesfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspects - {} has returned {}", joinPoint, resultValue);
    }
}
