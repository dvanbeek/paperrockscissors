package com.mvanniekerk.match;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    private static Stream<Arguments> provideArgumentsForRound() {
        return Stream.of(
                Arguments.of("rock", "rock", Result.DRAW),
                Arguments.of("rock", "paper", Result.LOSS),
                Arguments.of("rock", "scissors", Result.WIN),

                Arguments.of("paper", "rock", Result.WIN),
                Arguments.of("paper", "paper", Result.DRAW),
                Arguments.of("paper", "scissors", Result.LOSS),

                Arguments.of("scissors", "rock", Result.LOSS),
                Arguments.of("scissors", "paper", Result.WIN),
                Arguments.of("scissors", "scissors", Result.DRAW)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForRound")
    void getResultForPlayerTest(String playerMove, String aiMove, Result expected) {
        Round round = new Round(Move.parse(playerMove), Move.parse(aiMove));
        assertEquals(expected, round.getResultForPlayer());
    }

    @Test
    void toStringTest() {
        var expected = "You chose rock, the AI chose scissors, so you won.";
        var round = new Round(Move.fromInt(0), Move.fromInt(2));
        assertEquals(expected, round.toString());
    }
}