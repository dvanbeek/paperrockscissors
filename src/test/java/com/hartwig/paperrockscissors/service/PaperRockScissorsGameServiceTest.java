package com.hartwig.paperrockscissors.service;

import java.util.stream.Stream;

import com.hartwig.paperrockscissors.domain.Player;
import com.hartwig.paperrockscissors.domain.enums.Move;
import com.hartwig.paperrockscissors.domain.enums.Result;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperRockScissorsGameServiceTest {
    private final Player playerOne = new Player("playerOne");
    private final Player playerTwo = new Player("playerTwo");
    private final PaperRockScissorsGameService paperRockScissorsGameService = new PaperRockScissorsGameService(playerOne, playerTwo);

    private static Stream<Arguments> provideAllMoveVariations() {
        return Stream.of(
                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),
                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
                Arguments.of(Move.ROCK, Move.ROCK, Result.TIE),
                Arguments.of(Move.PAPER, Move.PAPER, Result.TIE),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.TIE),
                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE)
        );
    }

    private static Stream<Arguments> provideAllExpectedGameResults() {
        return Stream.of(
                Arguments.of(Move.ROCK, Move.SCISSORS, 1, 0, 0, 0, 1, 0),
                Arguments.of(Move.ROCK, Move.PAPER, 0, 1, 0, 1, 0, 0),
                Arguments.of(Move.ROCK, Move.ROCK, 0, 0, 1, 0, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideAllMoveVariations")
    void determineResultForPlayerOne_AllVariations(final Move playerOneMove, final Move playerTwoMove, final Result expectedResult) {
        assertEquals(expectedResult, paperRockScissorsGameService.determineResultForPlayerOne(playerOneMove, playerTwoMove));
    }

    @ParameterizedTest
    @MethodSource("provideAllExpectedGameResults")
    void determineResultForPlayerOne_AllGameResults(
            final Move playerOneMove,
            final Move playerTwoMove,
            final int playerOneWins,
            final int playerOneLosses,
            final int playerOneTies,
            final int playerTwoWins,
            final int playerTwoLosses,
            final int playerTwoTies
    ) {
        paperRockScissorsGameService.determineResultForPlayerOne(playerOneMove, playerTwoMove);

        assertEquals(playerOneWins, playerOne.getWins());
        assertEquals(playerOneLosses, playerOne.getLosses());
        assertEquals(playerOneTies, playerOne.getTies());
        assertEquals(playerTwoWins, playerTwo.getWins());
        assertEquals(playerTwoLosses, playerTwo.getLosses());
        assertEquals(playerTwoTies, playerTwo.getTies());
    }
}