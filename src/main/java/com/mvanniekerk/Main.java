package com.mvanniekerk;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public enum Result {
        WIN, LOSS, DRAW;

        static String toString(Result result) {
            return switch (result) {
                case WIN -> "won";
                case LOSS -> "lost";
                case DRAW -> "drew";
            };
        }
    }

    private static final String INSTRUCTIONS = """
            Let's play a game of Rock, Paper, Scissors.
            You will play against the computer.
            Type [rock|paper|scissors] and the computer will reveal its choice.
            Quit the game at any time by typing quit or ctrl+D.
            """;

    public static Result match(MatchChoice aiChoice, MatchChoice playerChoice) {
        if (aiChoice.equals(playerChoice)) {
            return Result.DRAW;
        }
        return aiChoice.beats(playerChoice) ? Result.LOSS : Result.WIN;
    }

    public static void main(String[] args) {
        System.out.println(INSTRUCTIONS);
        var scanner = new Scanner(System.in);
        var random = new Random();
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine().strip().toLowerCase();
            var aiChoice = MatchChoice.genRandom(random);
            var playerChoice = MatchChoice.parse(line);
            if (playerChoice != null) {
                var result = match(aiChoice, playerChoice);
                System.out.println("You " + Result.toString(result) + ".");
            } else if (line.equals("quit")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Please type either rock/paper/scissors or quit.");
            }
        }
    }
}