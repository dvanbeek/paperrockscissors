package model;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move parseMove(String moveStringRepresentation) {
        return switch (moveStringRepresentation.toLowerCase().strip()) {
            case "r" -> ROCK;
            case "p" -> PAPER;
            case "s" -> SCISSORS;
            default -> throw new IllegalArgumentException("Invalid move");
        };
    }

    public boolean winsAgainst(Move opponentMove) {
        if (opponentMove == null) {
            throw new NullPointerException("Opponent move cannot be null!");
        }
        return this == ROCK && opponentMove == SCISSORS
            || this == PAPER && opponentMove == ROCK
            || this == SCISSORS && opponentMove == PAPER;
    }
}
