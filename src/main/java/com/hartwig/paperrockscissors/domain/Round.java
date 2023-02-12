package com.hartwig.paperrockscissors.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Round(List<Move> movesPlayed) {

    public Round {
        if (containsMoreThanOneMovePerPlayer(movesPlayed)) {
            throw new IllegalStateException("Not allowed to do more than one move per Round");
        }
    }
    private boolean containsMoreThanOneMovePerPlayer(List<Move> list) {
        Set<Player> seen = new HashSet<>();
        for (Move move : list) {
            Player key = move.player();
            if (seen.contains(key)) {
                return true;
            }
            seen.add(key);
        }
        return false;
    }

}
