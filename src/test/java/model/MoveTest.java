package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    @Test
    public void parseValidMoveTest() {
        assertEquals(Move.ROCK, Move.parseMove("r"));
        assertEquals(Move.ROCK, Move.parseMove("R"));
        assertEquals(Move.PAPER, Move.parseMove("p"));
        assertEquals(Move.PAPER, Move.parseMove("P"));
        assertEquals(Move.SCISSORS, Move.parseMove("s"));
        assertEquals(Move.SCISSORS, Move.parseMove("S"));
    }

    @Test
    public void parseInvalidMoveTest() {
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("a"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("-1"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("1.2"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("-1,5"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("RR"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("rR"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("r R"));
        assertThrows(IllegalArgumentException.class, () -> Move.parseMove("prs"));
    }

    @Test
    public void winsAgainstTest() {
        assertTrue(Move.ROCK.winsAgainst(Move.SCISSORS));
        assertTrue(Move.PAPER.winsAgainst(Move.ROCK));
        assertTrue(Move.SCISSORS.winsAgainst(Move.PAPER));
    }

    @Test
    public void doesNotWinAgainstTest() {
        assertFalse(Move.ROCK.winsAgainst(Move.ROCK));
        assertFalse(Move.ROCK.winsAgainst(Move.PAPER));
        assertFalse(Move.PAPER.winsAgainst(Move.PAPER));
        assertFalse(Move.PAPER.winsAgainst(Move.SCISSORS));
        assertFalse(Move.SCISSORS.winsAgainst(Move.SCISSORS));
        assertFalse(Move.SCISSORS.winsAgainst(Move.ROCK));
    }

    @Test
    public void cannotWinNorLoseToUninitializedMove() {
        assertThrows(NullPointerException.class, () -> Move.ROCK.winsAgainst(null));
    }
}
