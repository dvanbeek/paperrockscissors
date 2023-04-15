package integrationtests;

import org.junit.jupiter.api.Test;
import paperrockscissors.Game;
import paperrockscissors.Move;
import paperrockscissors.io.CLI;
import paperrockscissors.io.IOInterface;
import paperrockscissors.players.ComputerPlayer;
import paperrockscissors.players.HumanPlayer;
import paperrockscissors.players.Player;
import paperrockscissors.players.strategies.RpsStrategy;
import paperrockscissors.rules.DefaultRules;
import paperrockscissors.rules.Rules;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestDefaultFlow {

    @Test
    public void TestExampleGame() {
        // a human player and a computer player take it on in a game of rock-paper-scissors
        String predefinedUserInput = """
                rock
                y
                paper
                y
                invalid-input
                scissors
                f
                rock
                y
                rock
                n
                """;
        System.setIn(new ByteArrayInputStream(predefinedUserInput.getBytes()));

        IOInterface cli = new CLI(new Scanner(System.in));
        Rules defaultRules = new DefaultRules();
        Player humanPlayer = new HumanPlayer("foo", cli);
        Player computerPlayer = new ComputerPlayer("Computron", new DummyStrategy());
        Game game = new Game(cli, defaultRules, humanPlayer, computerPlayer);

        game.nextRound();

        assertArrayEquals(new int[] {3, 1, 1}, game.getScoreboard());
    }

    private static class DummyStrategy implements RpsStrategy {

        @Override
        public Move calculateNextMove() {
            return Move.ROCK;
        }
    }

}