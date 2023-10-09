package com.hartwig.rpc.ui;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;

import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserMove() {
        System.out.print("Enter move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
        return scanner.nextLine();
    }

    @Override
    public void displayComputerMove(Move move) {
        System.out.println("Computer move: " + move);
    }

    @Override
    public void displayResult(Result result) {
        switch (result) {
            case WIN -> System.out.println("You win!");
            case LOSE -> System.out.println("You lose!");
            case TIE -> System.out.println("It's a tie!");
        }
    }

    @Override
    public void displayInvalidMoveMessage() {
        System.out.println("Invalid move; please try again.");
    }

    @Override
    public void displayResults(int wins, int losses, int ties) {
        System.out.println("Game Summary:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }
}
