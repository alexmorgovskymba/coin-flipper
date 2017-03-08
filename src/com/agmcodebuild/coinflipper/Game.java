package com.agmcodebuild.coinflipper;

import java.util.Scanner;

/**
 * The Game command-line app allows the player
 * to call heads/tails on a coin toss all the way
 * until the player loses.
 *
 * @author  Alexander Morgovsky
 * @version 1.0
 * @since   2017-03-08
 */

public class Game {

    public static String flipCoin(){
        if(Math.random() < 0.5) {
           return "TAILS";
        }
        else {
            return "HEADS";
        }
    }

    public static String getPrettyInput(String input){
        if (input.equals("h")){
            return "HEADS";
        } else if (input.equals("t")){
            return "TAILS";
        }
        return "FAIL";
    }

    public static void main(String[] args) {
        int correctFlips = 0;
        String prettyInput = "";
        String currentFlip = "";
        String currentFlipMessage = "";
        boolean gameOver = false;
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        while (!gameOver) {
            System.out.println("[h]eads, [t]ails, or [s]top?");
            input = inputScanner.nextLine();
            if (!input.equals("s") && (input.equals("h") || input.equals("t"))) {
                prettyInput = getPrettyInput(input);
                currentFlip = flipCoin();
                if (prettyInput.equals(currentFlip)) {
                    currentFlipMessage = "Great, it's a match!";
                    correctFlips++;
                    System.out.format("You called %s, the flip was %s; %s", prettyInput, currentFlip, currentFlipMessage);
                    System.out.println();
                } else {
                    currentFlipMessage = "Sorry, no match!";
                    System.out.format("You called %s, the flip was %s; %s", prettyInput, currentFlip, currentFlipMessage);
                    System.out.println();
                    System.out.println("Thanks for playing!");
                    System.out.println("You called " + correctFlips + " flips.");
                    gameOver = true;
                }
            } else {
                System.out.println("Thanks for playing!");
                System.out.println("You called " + correctFlips + " flips.");
                gameOver = true;
            }
        }
    }
}
