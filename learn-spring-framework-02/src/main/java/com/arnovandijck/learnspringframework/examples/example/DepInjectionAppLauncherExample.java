package com.arnovandijck.learnspringframework.examples.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class DepInjectionAppLauncherExample {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(DepInjectionAppLauncherExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
