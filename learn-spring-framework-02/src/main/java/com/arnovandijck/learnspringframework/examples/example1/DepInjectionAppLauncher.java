package com.arnovandijck.learnspringframework.examples.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {
    Dependency dependency;

    @Autowired
    public YourBusinessClass(Dependency dependency) {
        super();
        System.out.println("Constructor injection");
        this.dependency = dependency;
    }

    public String toString() {
        return "YourBusinessClass";
    }
}

@Component
class Dependency {

}

@Configuration
@ComponentScan
public class DepInjectionAppLauncher {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(DepInjectionAppLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            context.getBean(YourBusinessClass.class);
        }
    }
}
