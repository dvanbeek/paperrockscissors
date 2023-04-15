package paperrockscissors.io;

import org.junit.jupiter.api.Test;
import paperrockscissors.Move;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CLITest {

    @Test
    public void testPromptNextMoveValid() {
        String input = "rock";
        Scanner dummyScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        IOInterface cli = new CLI(dummyScanner);
        Move move = cli.promptNextMove("Foo");
        assertEquals(Move.ROCK, move);
    }

    @Test
    public void testPromptAnotherRoundYes() {
        String input = "y";
        Scanner dummyScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        IOInterface cli = new CLI(dummyScanner);
        assertTrue(cli.promptPlayAnotherRound());
    }

    @Test
    public void testPromptAnotherRoundNo() {
        String input = "n";
        Scanner dummyScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        IOInterface cli = new CLI(dummyScanner);
        assertFalse(cli.promptPlayAnotherRound());
    }

    @Test
    public void testPromptAnotherRoundDefault() {
        String input = "default";
        Scanner dummyScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        IOInterface cli = new CLI(dummyScanner);
        assertTrue(cli.promptPlayAnotherRound());
    }

}
