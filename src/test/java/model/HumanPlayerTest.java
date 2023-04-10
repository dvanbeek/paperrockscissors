package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {

    HumanPlayer humanPlayer;

    @BeforeEach
    public void setup() {
        humanPlayer = new HumanPlayer("Hartwig");
    }

    @Test
    public void getNameTest() {
        assertEquals("Hartwig", humanPlayer.getName());
        assertNotEquals("Computer", humanPlayer.getName());
    }

    @Test
    public void getAndSetCurrentMoveTest() {
        assertEquals(null, humanPlayer.getCurrentMove());
        humanPlayer.setMove(Move.ROCK);
        assertEquals(Move.ROCK, humanPlayer.getCurrentMove());
        assertNotEquals(Move.SCISSORS, humanPlayer.getCurrentMove());
        humanPlayer.setMove(Move.PAPER);
        assertEquals(Move.PAPER, humanPlayer.getCurrentMove());
    }
}
