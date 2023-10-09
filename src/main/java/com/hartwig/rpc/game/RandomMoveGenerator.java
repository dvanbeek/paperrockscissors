package com.hartwig.rpc.game;

import com.hartwig.rpc.datamodel.Move;

import java.util.Random;

public class RandomMoveGenerator implements MoveGenerator {
    private final Random random = new Random();

    @Override
    public Move generateMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
