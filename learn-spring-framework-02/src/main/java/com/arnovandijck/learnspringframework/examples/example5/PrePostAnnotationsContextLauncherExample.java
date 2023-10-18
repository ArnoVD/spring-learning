package com.arnovandijck.learnspringframework.examples.example5;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("SomeClass constructor");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("SomeClass cleanUp");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("SomeDependency getReady");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherExample {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
