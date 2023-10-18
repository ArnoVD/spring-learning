package com.arnovandijck.learnspringframework.examples.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BusinessAppLauncher {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(BusinessAppLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            var businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.findMax());
        }
    }
}
