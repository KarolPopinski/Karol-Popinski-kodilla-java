package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        while (!GameController.getInstance().gameIsFinished()) {

            GameController.getInstance().intro();
            GameController.getInstance().getGameWinner();
        }
    }
}
