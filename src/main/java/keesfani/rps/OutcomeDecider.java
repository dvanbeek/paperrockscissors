package keesfani.rps;

import java.util.*;

class OutcomeDecider {
    EnumMap<Move, Set<Move>> beats;

    OutcomeDecider() {
        beats = new EnumMap<>(Move.class);

        beats(Move.PAPER, Move.ROCK);
        beats(Move.ROCK, Move.SCISSORS);
        beats(Move.SCISSORS, Move.PAPER);
    }

    private void beats(Move move, Move... beatenMoves) {
        beats.put(move, Set.of(beatenMoves));
    }

    Outcome determineOutcome(Move move, Move opponentMove) {
        if (move == opponentMove) {
            return Outcome.TIE;
        } else if (beats.get(move).contains(opponentMove)) {
            return Outcome.WIN;
        } else {
            return Outcome.LOSS;
        }
    }
}
