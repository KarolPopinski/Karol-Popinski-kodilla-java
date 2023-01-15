package com.kodilla.rps;

public class GameItems {

    public static final String rock = "ROCK";
    public static final String paper = "PAPER";
    public static final String scissors = "SCISSORS";

    public final Item items(char itemNumber ) {
        switch (itemNumber) {
            case '1':
                return new Rock(rock);
            case '2':
                return new Paper(paper);
            case '3':
                return new Scissors(scissors);
            default:
                return null;
        }
    }
}

