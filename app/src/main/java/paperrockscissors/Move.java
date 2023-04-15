package paperrockscissors;

import java.util.Set;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Set<Move> getAllMoves() {
        return Set.of(ROCK, PAPER, SCISSORS);
    }
}
