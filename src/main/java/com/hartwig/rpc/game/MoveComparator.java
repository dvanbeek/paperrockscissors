package com.hartwig.rpc.game;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;

public class MoveComparator {
    public Result compareMoves(Move move1, Move move2) {
        if (move1 == move2) {
            return Result.TIE;
        }
        return switch (move1) {
            case ROCK -> (move2 == Move.SCISSORS) ? Result.WIN : Result.LOSE;
            case PAPER -> (move2 == Move.ROCK) ? Result.WIN : Result.LOSE;
            case SCISSORS -> (move2 == Move.PAPER) ? Result.WIN : Result.LOSE;
        };
    }
}
