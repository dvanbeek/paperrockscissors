package com.mvanniekerk;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private enum Choice {
        ROCK, PAPER, SCISSORS;

        private static Choice parse(String input) {
            return switch (input) {
                case "rock" -> Choice.ROCK;
                case "paper" -> Choice.PAPER;
                case "scissors" -> Choice.SCISSORS;
                default -> null;
            };
        }

        private static Choice genRandom(Random random) {
            var num = random.nextInt(0, 3);
            return switch (num) {
                case 0 -> Choice.ROCK;
                case 1 -> Choice.PAPER;
                case 2 -> Choice.SCISSORS;
                default -> throw new IllegalStateException("Random number should be 0/1/2.");
            };
        }
    }

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

    public static Result match(Choice ai, Choice player) {
        if (ai == player) {
            return Result.DRAW;
        }
        return beats(ai, player) ? Result.LOSS : Result.WIN;
    }

    private static boolean beats(Choice a, Choice b) {
        return switch(a) {
            case ROCK -> b == Choice.SCISSORS;
            case PAPER -> b == Choice.ROCK;
            case SCISSORS -> b == Choice.PAPER;
        };
    }

    public static void main(String[] args) {
        System.out.println(INSTRUCTIONS);
        var scanner = new Scanner(System.in);
        var random = new Random();
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine().strip().toLowerCase();
            var aiChoice = Choice.genRandom(random);
            var playerChoice = Choice.parse(line);
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