package com.arnovandijck.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppHelloWorldSpring {
    public static void main(String[] args) {
        // 1: Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            // try-with-resources

            // 2: Configure the things that we want Spring to manage - @Configuration
            // HelloWorldConfiguration = @Configuration
            // name = @Bean

            // 3: Retrieving Beans managed by Spring
            var name = context.getBean("name");
            var age = context.getBean("age");
            System.out.println(name);
            System.out.println(age);

            var person = context.getBean("person");
            var personMethodCall = context.getBean("personMethodCall");
            var personParameters = context.getBean("personParameters");
            var address = context.getBean("personAddress");
            System.out.println(person);
            System.out.println(personMethodCall);
            System.out.println(personParameters);
            System.out.println(address);

            // Print all definition names in the HelloWorldConfiguration context
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // Print the primary address which has the @Primary annotation
            var primaryAddress = context.getBean(Address.class);
            System.out.println(primaryAddress);

            // Print the person with the address2Qualifier
            var personWithQualifier = context.getBean("personWithQualifier");
            System.out.println(personWithQualifier);
        }
    }
}
