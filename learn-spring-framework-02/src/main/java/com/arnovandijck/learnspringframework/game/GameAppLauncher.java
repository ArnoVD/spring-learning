package com.arnovandijck.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.arnovandijck.learnspringframework.game")
public class GameAppLauncher {
    public static void main(String[] args) {
        // try with resources will close the context after the try block
        try (var context = new AnnotationConfigApplicationContext(GameAppLauncher.class)) {
           context.getBean(Game.class).up();
           context.getBean(GameRunner.class).run();
        }
    }
}
