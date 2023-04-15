package paperrockscissors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    @Test
    public void testRockFromString() {
        String rockString1 = "rock";
        String rockString2 = "ROCK";
        String rockString3 = " RoCk  ";

        Move move1 = Move.fromString(rockString1);
        Move move2 = Move.fromString(rockString2);
        Move move3 = Move.fromString(rockString3);
        assertEquals(Move.ROCK, move1);
        assertEquals(Move.ROCK, move2);
        assertEquals(Move.ROCK, move3);
    }


    @Test
    public void testPaperFromString() {
        String paperString1 = "paper";
        String paperString2 = "PAPER";
        String paperString3 = " pApEr  ";

        Move move1 = Move.fromString(paperString1);
        Move move2 = Move.fromString(paperString2);
        Move move3 = Move.fromString(paperString3);
        assertEquals(Move.PAPER, move1);
        assertEquals(Move.PAPER, move2);
        assertEquals(Move.PAPER, move3);
    }


    @Test
    public void testScissorsFromString() {
        String scissorString1 = "scissors";
        String scissorString2 = "SCISSORS";
        String scissorString3 = " sCiSSorS  ";

        Move move1 = Move.fromString(scissorString1);
        Move move2 = Move.fromString(scissorString2);
        Move move3 = Move.fromString(scissorString3);
        assertEquals(Move.SCISSORS, move1);
        assertEquals(Move.SCISSORS, move2);
        assertEquals(Move.SCISSORS, move3);
    }
}
