package com.hartwig.paperrockscissors.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static com.hartwig.paperrockscissors.domain.Choice.PAPER;
import static com.hartwig.paperrockscissors.domain.Choice.ROCK;
import static com.hartwig.paperrockscissors.domain.Choice.SCISSORS;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TwoPlayerGameTest {

    private final TwoPlayerGame game = new TwoPlayerGame();

    @Test
    void fetchPossibleChoice_shouldReturnAllPossibleChoicesExceptUnknown() {
        var expected = EnumSet.of(ROCK, PAPER, SCISSORS);
        assertEquals(expected, game.fetchPossibleChoice());
    }

    @Test
    void playRound_shouldAddRoundToListOfRounds() {
        var round = new Round(of(new Move(new Player("Alice"), PAPER),
                                 new Move(new Player("Bob"), SCISSORS)));
        game.playRound(round);
        assertEquals(1, game.rounds().size());
    }

    @Test
    void playRound_shouldThrowIfMoreThanTwoMovesPlayed() {
        var round = new Round(of(new Move(new Player("Alice"), PAPER),
                                 new Move(new Player("Bob"), SCISSORS),
                                 new Move(new Player("Charlie"), ROCK)));
        assertThrows(IllegalStateException.class, () -> game.playRound(round));
    }

    @Test
    void determineScore_shouldReturnScoreBasedOnRoundsPlayed() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        game.playRound(new Round(of(new Move(alice, PAPER),
                                    new Move(bob, SCISSORS))));
        game.playRound(new Round(of(new Move(alice, ROCK),
                                    new Move(bob, PAPER))));
        game.playRound(new Round(of(new Move(alice, SCISSORS),
                                    new Move(bob, SCISSORS))));
        game.playRound(new Round(of(new Move(alice, SCISSORS),
                                    new Move(bob, ROCK))));
        var score = game.determineScore();
        assertEquals(0, score.results().get(alice).won());
        assertEquals(3, score.results().get(alice).lost());
        assertEquals(1, score.results().get(alice).tied());
        assertEquals(3, score.results().get(bob).won());
        assertEquals(0, score.results().get(bob).lost());
        assertEquals(1, score.results().get(bob).tied());
    }
}
