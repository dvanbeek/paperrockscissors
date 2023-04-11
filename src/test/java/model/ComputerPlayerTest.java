package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {
    ComputerPlayer computerPlayer;

    @BeforeEach
    public void setup() {
        computerPlayer = new ComputerPlayer("Computer");
    }

    @Test
    public void setRandomCurrentMoveSetsValidMoveTest() {
        assertEquals(null, computerPlayer.getCurrentMove());
        computerPlayer.setRandomMove();
        assertTrue(computerPlayer.getCurrentMove() == Move.ROCK
                || computerPlayer.getCurrentMove() == Move.PAPER
                || computerPlayer.getCurrentMove() == Move.SCISSORS);
    }
}
