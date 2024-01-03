import computer.Computer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import score.Player;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperRockScissorsTest {

    @Test
    void runGameLoop() {
        Player player = new Player();
        PaperRockScissors paperRockScissors = new PaperRockScissors(player, new Computer(new Random(1))); // use seed for testing purposes
        Scanner scanner = Mockito.mock(Scanner.class);
        // mock user input
        Mockito.when(scanner.nextLine()).thenReturn("p", "paper", "pap", "paper", "r", "rock", "s", "r", "scissors", "x", "foo", "q");
        paperRockScissors.runGameLoop(scanner);
        // we know the outcomes because we use a seed for the computer's random shapes
        assertAll("test outcomes",
                () -> assertEquals(4, player.getWins()),
                () -> assertEquals(3, player.getLosses()),
                () -> assertEquals(1, player.getTies()));
    }
}