package keesfani.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutcomeDeciderTest {

    @Test
    void testAllPermutations() {
        OutcomeDecider outcomeDecider = new OutcomeDecider();

        assertEquals(Outcome.WIN, outcomeDecider.determineOutcome(Move.PAPER, Move.ROCK));
        assertEquals(Outcome.WIN, outcomeDecider.determineOutcome(Move.SCISSORS, Move.PAPER));
        assertEquals(Outcome.WIN, outcomeDecider.determineOutcome(Move.ROCK, Move.SCISSORS));

        assertEquals(Outcome.TIE, outcomeDecider.determineOutcome(Move.PAPER, Move.PAPER));
        assertEquals(Outcome.TIE, outcomeDecider.determineOutcome(Move.SCISSORS, Move.SCISSORS));
        assertEquals(Outcome.TIE, outcomeDecider.determineOutcome(Move.ROCK, Move.ROCK));

        assertEquals(Outcome.LOSS, outcomeDecider.determineOutcome(Move.ROCK, Move.PAPER));
        assertEquals(Outcome.LOSS, outcomeDecider.determineOutcome(Move.SCISSORS, Move.ROCK));
        assertEquals(Outcome.LOSS, outcomeDecider.determineOutcome(Move.PAPER, Move.SCISSORS));
    }
}
