package com.arnovandijck.learnspringframework.examples.example7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherExample {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));
        }
    }
}
