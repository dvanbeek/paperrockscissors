package com.hartwig.paperrockscissors.service;

import java.util.Map;

import com.hartwig.paperrockscissors.domain.Player;
import com.hartwig.paperrockscissors.domain.enums.Move;
import com.hartwig.paperrockscissors.domain.enums.Result;
import com.hartwig.paperrockscissors.service.interfaces.PaperRockScissorsGame;
import lombok.Getter;

public record PaperRockScissorsGameService(@Getter Player playerOne,
                                           @Getter Player playerTwo) implements PaperRockScissorsGame {
    private static final Map<Move, Move> WINNING_RESULTS = Map.of(
            Move.ROCK, Move.SCISSORS,
            Move.PAPER, Move.ROCK,
            Move.SCISSORS, Move.PAPER
    );

    @Override
    public Result determineResultForPlayerOne(final Move playerOneMove, final Move playerTwoMove) {
        if (playerOneMove == playerTwoMove) {
            playerOne.addResult(Result.TIE);
            playerTwo.addResult(Result.TIE);
            return Result.TIE;
        }
        if (WINNING_RESULTS.get(playerOneMove) == playerTwoMove) {
            playerOne.addResult(Result.WIN);
            playerTwo.addResult(Result.LOSE);
            return Result.WIN;
        }
        playerOne.addResult(Result.LOSE);
        playerTwo.addResult(Result.WIN);
        return Result.LOSE;
    }
}
