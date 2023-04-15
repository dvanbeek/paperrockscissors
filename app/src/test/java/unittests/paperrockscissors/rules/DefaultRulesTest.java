package unittests.paperrockscissors.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import paperrockscissors.Move;
import paperrockscissors.rules.DefaultRules;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultRulesTest {

    private DefaultRules rules;

    @BeforeEach
    public void setUp() {
        rules = new DefaultRules();
    }

    @Test
    public void testRockBeatsScissors() {
        assertEquals(1, rules.decideWinner(Move.ROCK, Move.SCISSORS));
        assertEquals(2, rules.decideWinner(Move.SCISSORS, Move.ROCK));
    }

    @Test
    public void testPaperBeatsRock() {
        assertEquals(1, rules.decideWinner(Move.PAPER, Move.ROCK));
        assertEquals(2, rules.decideWinner(Move.ROCK, Move.PAPER));
    }

    @Test
    public void testScissorsBeatsPaper() {
        assertEquals(1, rules.decideWinner(Move.SCISSORS, Move.PAPER));
        assertEquals(2, rules.decideWinner(Move.PAPER, Move.SCISSORS));
    }

    @Test
    public void testDraw() {
        assertEquals(0, rules.decideWinner(Move.ROCK, Move.ROCK));
        assertEquals(0, rules.decideWinner(Move.PAPER, Move.PAPER));
        assertEquals(0, rules.decideWinner(Move.SCISSORS, Move.SCISSORS));

    }


}
