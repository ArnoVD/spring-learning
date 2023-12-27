package com.arnovandijck.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutsConfig {

    // Intercepts all methods in the package com.arnovandijck.learnspringaop.aopexample
    @Pointcut("execution(* com.arnovandijck.learnspringaop.aopexample.*.*.*(..))")
    public void aopExamplePackageConfig() {}

    // Intercepts all methods in the package com.arnovandijck.learnspringaop.aopexample.business
    @Pointcut("execution(* com.arnovandijck.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    // Intercepts all methods in the package com.arnovandijck.learnspringaop.aopexample.data
    @Pointcut("execution(* com.arnovandijck.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    // Intercepts all classes that have Service in their name
    @Pointcut("bean(*Service*)")
    public void allServiceConfig() {}

    @Pointcut("@annotation(com.arnovandijck.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
