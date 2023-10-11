package com.arnovandijck.learnspringframework.game;

public class AppGamingWithJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);

        gameRunner.run();
    }
}
