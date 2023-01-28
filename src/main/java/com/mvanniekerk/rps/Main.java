package com.mvanniekerk.rps;

import com.mvanniekerk.rps.match.Move;

import java.util.Scanner;

public class Main {

    private static final String INSTRUCTIONS = """
            Let's play a game of Rock, Paper, Scissors.
            You will play against the computer.
            Type [rock|paper|scissors] and the computer will reveal its choice.
            Quit the game at any time by typing quit or ctrl+D.
            """;

    public static void main(String[] args) {
        System.out.println(INSTRUCTIONS);
        var scanner = new Scanner(System.in);
        var game = Game.randomGame();
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine().strip().toLowerCase();
            var playerMove = Move.parse(line);
            if (playerMove != null) {
                System.out.println(game.playRound(playerMove));
            } else if (line.equals("quit")) {
                break;
            } else {
                System.out.println("Please type either rock/paper/scissors or quit.");
            }
        }
        System.out.println("Thanks for playing!\n" + game.getStats());
    }
}