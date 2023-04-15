package paperrockscissors;

import java.util.Set;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Set<Move> getAllMoves() {
        return Set.of(ROCK, PAPER, SCISSORS);
    }

    public static Move fromString(String moveString) {
        return switch (moveString.toLowerCase().trim()) {
            case "rock" -> ROCK;
            case "paper" -> PAPER;
            case "scissors" -> SCISSORS;
            default -> null;
        };
    }
}
