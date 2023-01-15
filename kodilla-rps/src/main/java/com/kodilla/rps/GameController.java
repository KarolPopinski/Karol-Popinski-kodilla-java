package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class GameController {

    private Scanner scanner = new Scanner(System.in);

    private static GameController gameInstance = null;

    private String playerName;
    private int playerDecisionRoundsToWin;
    private char playerChoice;
    private char computerChoice;
    private int playerWin;
    private int computerWin;
    private Item playerItem;
    private Item computerItem;

    private boolean end = false;

    private GameController() {
    }

    public static GameController getInstance() {
        if (gameInstance == null) {
            gameInstance = new GameController();
        }
        return gameInstance;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerChoice() {
        return playerChoice;
    }

    public char getComputerChoice() {
        return computerChoice;
    }

    public boolean gameIsFinished() {
        return end;
    }

    public void intro() {

        playerWin = 0;
        computerWin = 0;

        System.out.println("\n"+
                "Welcome to: ***ROCK PAPER SCISSORS Game*** ");

        System.out.println("\n" + "My name is CrazyPC and I will be your opponent in this game.\n"+
                "First of all, let me say that it will not be easy to beat me.\n"+
                "Remember that behind me is a team of AI specialists!\n");

        System.out.println("Please enter Your name?");
        playerName = scanner.next();

        System.out.println("\nOK "+ playerName + " Let's start the challenge!!!\n"+
                "Enter below: how many won rounds, do we play?\n"+
                "*** please use only number keys ***");
        playerDecisionRoundsToWin = scanner.nextInt();
        System.out.println(playerName+" chose: "+playerDecisionRoundsToWin);
        System.out.println("OK that is: "+playerDecisionRoundsToWin+
                " number of won rounds will decide who won the game!\n"+
                "let's start");

        System.out.println( "                               \n"+
                            "           RPS GAME MENU       \n"+
                            "                               \n"+
                            "            1. ROCK            \n"+
                            "            2. PAPER           \n"+
                            "            3. SCISSOR         \n"+
                            "            x. END GAME        \n"+
                            "            n. NEW GAME        \n"+
                            "                               \n");
    }

    public void chooseNumber() {
        System.out.println(playerName+" please make a choice: ");
        playerChoice = scanner.next().charAt(0);

        int random = new Random().nextInt(3) + 1;
        computerChoice = (char) (random + '0');
        if (playerChoice == 'x') {
            endGame();
        } else if (playerChoice == 'n') {
            newGame();
        }
    }

    public void getItems(char playerChoice, char computerChoice) {
        playerItem = new GameItems().items(playerChoice);
        computerItem = new GameItems().items(computerChoice);
        System.out.println(playerName+" chose: "+playerItem.getItemName()+"\n"+
                "CrazyPC chose: "+computerItem.getItemName());
    }

    public void getRoundWinner(Item playerItem, Item computerItem) {
        if (playerItem.getItemName().equals(computerItem.getItemName())) {
            System.out.println("There is TIE - no winner in this round");
        } else if (playerItem.beats().contains(computerItem.getItemName())) {
            playerWin++;
            System.out.println(playerName + " Yes,Yes, Yes - You Won!!! :-)");
        } else {
            computerWin++;
            System.out.println("Sorry, but CrazyPC WON! :-(");
        }
    }

    public void getGameWinner() {
        int roundCount = 0;
        while (playerWin < playerDecisionRoundsToWin && computerWin < playerDecisionRoundsToWin) {

            roundCount++;
            chooseNumber();
            getItems(playerChoice, computerChoice);
            getRoundWinner(playerItem, computerItem);
            System.out.println("\nSummary round No:"+roundCount+" "+playerName+" wins:"+playerWin+" || CrazyPC wins: "+computerWin);
            if (playerWin < playerDecisionRoundsToWin && computerWin < playerDecisionRoundsToWin) {
                if (playerWin > computerWin) {
                    System.out.println("Okay you made it, but don't get distracted. Remember the game is still on.\n");
                } else {
                    System.out.println("Nothing happened, let's keep playing \n");
                }
            }
        }
        System.out.println("\nAfter "+roundCount+" round(s), it's time to announce the winner:\n");
        if (playerWin > computerWin) {
            System.out.println(playerName + "yes, you really won this Game!!!!!!!!!\n"+
                    "Sincere congratulations - you really made it!");
        } else {
            System.out.println("Sorry "+playerName+" you really tried but CrazyPC WIN this Game.\n"+
                    "Keep your head up. It's not his success, but the AI people's\n"+
                    "And remember, you can still beat CrazyPC ...... just try again.");
        }
        System.out.println("\nPlay again? Press N(New Game) or X(End Game)");
        char decisionAgain = scanner.next().charAt(0);
        switch (decisionAgain) {
            case 'x': {
                endGame();
                break;
            }
            case 'n': {
                newGame();
                break;
            }
            default:
                break;
        }
    }

    public void endGame() {
        System.out.println("Are you sure you want to end the game? Y(Yes) or N(No)?");
        char endGame = scanner.next().charAt(0);
        switch (endGame) {
            case 'y': {
                end = true;
                System.exit(0);
                break;
            }
            case 'n': {
                newGame();
                break;
            }
            default:
                break;
        }
    }


    public void newGame() {
        System.out.println("Are you sure you want to start a new game? Y(Yes) N(No)\n"+
                "Warning: if you are in the middle of the game, it means that you will lose your current results.");

        char newGame = scanner.next().charAt(0);
        switch (newGame) {
            case 'y': {
                intro();
                getGameWinner();
                break;
            }
            case 'n': {
                end = true;
                endGame();
                break;
            }
            default:
                break;
        }
    }
}