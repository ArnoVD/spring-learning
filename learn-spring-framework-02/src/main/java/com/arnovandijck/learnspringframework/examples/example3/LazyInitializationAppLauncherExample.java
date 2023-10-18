package com.arnovandijck.learnspringframework.examples.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class ClassA {
    public ClassA() {
        System.out.println("classA");
    }
}

@Component
@Lazy
class classB {

    private ClassA classA;
    public classB(ClassA classA) {
        System.out.println("Some initializaton logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationAppLauncherExample {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationAppLauncherExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("After initialization");

            context.getBean(classB.class).doSomething();
        }
    }
}
