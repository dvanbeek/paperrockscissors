package com.mvanniekerk.rps.match;

public class Move {
    private enum MoveType {
        ROCK, PAPER, SCISSORS;
    }

    private final MoveType choice;

    private Move(MoveType moveType) {
        this.choice = moveType;
    }

    /**
     *
     * @param input string representation of a move
     * @return Move or null if the string is not a move.
     */
    public static Move parse(String input) {
        return switch (input) {
            case "rock" -> new Move(MoveType.ROCK);
            case "paper" -> new Move(MoveType.PAPER);
            case "scissors" -> new Move(MoveType.SCISSORS);
            default -> null;
        };
    }

    /**
     *
     * @param number integer representation of a move.
     * @return the move.
     */
    public static Move fromInt(int number) {
        if (number < 0 || number > 2) {
            throw new IllegalArgumentException("Number should be 0, 1, or 2");
        }
        return new Move(MoveType.values()[number]);
    }

    boolean beats(Move other) {
        return switch (choice) {
            case ROCK -> other.choice == MoveType.SCISSORS;
            case PAPER -> other.choice == MoveType.ROCK;
            case SCISSORS -> other.choice == MoveType.PAPER;
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

        return choice == ((Move) o).choice;
    }

    @Override
    public int hashCode() {
        return choice.hashCode();
    }
}
