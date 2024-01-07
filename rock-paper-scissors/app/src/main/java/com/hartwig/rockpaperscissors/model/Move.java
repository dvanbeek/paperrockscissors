package com.hartwig.rockpaperscissors.model;

import java.util.Random;

public enum Move {

    Rock,
    Paper,
    Scissors;

    public static Move getRandom() {
		Move[] moves = Move.values();
		return moves[new Random().nextInt(moves.length)];
    }
}
