package com.arnovandijck.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String streetName, int houseNumber, String city) {};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Arno";
    }

    @Bean
    public int age() {
        return 26;
    }

    @Bean
    public Person person() {
        return new Person("Anne-Sophie", 26, new Address("Baker Street", 100, "London"));
    }

    @Bean
    public Person personMethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person personParameters(String name, int age, Address address2) {
        return new Person(name, age, address2);
    }

    @Bean
    public Person personWithQualifier(String name, int age, @Qualifier("address2Qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "personAddress")
    @Primary
    public Address address() {
        return new Address("Aarschotsesteenweg", 139, "Tienen");
    }

    @Bean
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("Sint-barabarestraat", 55, "Kumtich");
    }


}
