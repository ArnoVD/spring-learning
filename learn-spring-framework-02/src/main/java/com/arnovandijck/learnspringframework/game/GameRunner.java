package com.arnovandijck.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    Game game;
    public GameRunner(@Qualifier("superContraGame") Game game) {
        this.game = game;
    }

    public void run () {
        System.out.println("Running game");

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
