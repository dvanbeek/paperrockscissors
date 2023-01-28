package com.mvanniekerk;

import java.util.Random;

public class MatchChoice {
    private enum Choice {
        ROCK, PAPER, SCISSORS;
    }

    private final Choice choice;

    private MatchChoice(Choice choice) {
        this.choice = choice;
    }

    public static MatchChoice parse(String input) {
        return switch (input) {
            case "rock" -> new MatchChoice(Choice.ROCK);
            case "paper" -> new MatchChoice(Choice.PAPER);
            case "scissors" -> new MatchChoice(Choice.SCISSORS);
            default -> null;
        };
    }

    public static MatchChoice genRandom(Random random) {
        var num = random.nextInt(0, 3);
        return new MatchChoice(Choice.values()[num]);
    }

    public boolean beats(MatchChoice other) {
        return switch (choice) {
            case ROCK -> other.choice == Choice.SCISSORS;
            case PAPER -> other.choice == Choice.ROCK;
            case SCISSORS -> other.choice == Choice.PAPER;
        };
    }

    @Override
    public String toString() {
        return choice.toString().toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return choice == ((MatchChoice) o).choice;
    }

    @Override
    public int hashCode() {
        return choice.hashCode();
    }
}
