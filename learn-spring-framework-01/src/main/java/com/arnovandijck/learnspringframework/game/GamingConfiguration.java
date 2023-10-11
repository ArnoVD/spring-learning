package com.arnovandijck.learnspringframework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {

    @Bean
    @Primary
    public GamingConsole marioGame() {
        return new MarioGame();
    }

    @Bean
    public GamingConsole SuperContraGame() {
        return new SuperContraGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
}
