package keesfani.rps;

import java.util.Random;

enum Move {
    ROCK, PAPER, SCISSORS;

    private static final Random random = new Random();

    static Move randomMove() {
        return values()[random.nextInt(Move.values().length)];
    }

    static Move fromString(String input) {
        return switch (input) {
            case "rock" -> ROCK;
            case "paper" -> PAPER;
            case "scissors" -> SCISSORS;
            default -> null;
        };
    }
}
