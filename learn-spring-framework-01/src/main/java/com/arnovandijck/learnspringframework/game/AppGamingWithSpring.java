package com.arnovandijck.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGamingWithSpring {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();
        }
    }
}
