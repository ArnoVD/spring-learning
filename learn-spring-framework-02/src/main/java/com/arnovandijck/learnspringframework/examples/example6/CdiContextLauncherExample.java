package com.arnovandijck.learnspringframework.examples.example6;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named // jakarta inject
class BusinessService {
    DataService dataService;
    public BusinessService(DataService dataService) {
        System.out.println("businessService constructor");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        System.out.println("businessService getter");
        return dataService;
    }

    // @Autowired
    @Inject // jakarta inject
    public void setDataService(DataService dataService) {
        System.out.println("businessService setter");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {
    public DataService() {
        System.out.println("dataService constructor");
    }
}

@Configuration
@ComponentScan
public class CdiContextLauncherExample {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
