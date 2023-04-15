package unittests.paperrockscissors;


import org.junit.jupiter.api.Test;

import paperrockscissors.Game;
import paperrockscissors.Move;
import paperrockscissors.io.IOInterface;
import paperrockscissors.players.Player;
import paperrockscissors.rules.Rules;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class GameTest {

    @Test
    public void testNextRoundPlayer1Wins() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Rules rules = mock(Rules.class);
        IOInterface cli = mock(IOInterface.class);
        when(playerOne.makeMove()).thenReturn(Move.ROCK);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);
        when(rules.decideWinner(Move.ROCK, Move.SCISSORS)).thenReturn(1);
        Game game = new Game(cli, rules, playerOne, playerTwo);

        game.nextRound();
        verify(playerOne, times(1)).makeMove();
        verify(playerTwo, times(1)).makeMove();
        verify(rules, times(1)).decideWinner(Move.ROCK, Move.SCISSORS);
        verify(cli, times(1)).promptPlayAnotherRound();

        assertArrayEquals(new int[] {0, 1, 0}, game.getScoreboard());
    }

    @Test
    public void testNextRoundPlayer2Wins() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Rules rules = mock(Rules.class);
        IOInterface cli = mock(IOInterface.class);
        when(playerOne.makeMove()).thenReturn(Move.PAPER);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);
        when(rules.decideWinner(Move.PAPER, Move.SCISSORS)).thenReturn(2);
        Game game = new Game(cli, rules, playerOne, playerTwo);

        game.nextRound();
        verify(playerOne, times(1)).makeMove();
        verify(playerTwo, times(1)).makeMove();
        verify(rules, times(1)).decideWinner(Move.PAPER, Move.SCISSORS);
        verify(cli, times(1)).promptPlayAnotherRound();

        assertArrayEquals(new int[] {0, 0, 1}, game.getScoreboard());
    }

    @Test
    public void testNextRoundDraw() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Rules rules = mock(Rules.class);
        IOInterface cli = mock(IOInterface.class);
        when(playerOne.makeMove()).thenReturn(Move.SCISSORS);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);
        when(rules.decideWinner(Move.SCISSORS, Move.SCISSORS)).thenReturn(0);
        Game game = new Game(cli, rules, playerOne, playerTwo);

        game.nextRound();
        verify(playerOne, times(1)).makeMove();
        verify(playerTwo, times(1)).makeMove();
        verify(rules, times(1)).decideWinner(Move.SCISSORS, Move.SCISSORS);
        verify(cli, times(1)).promptPlayAnotherRound();

        assertArrayEquals(new int[] {1, 0, 0}, game.getScoreboard());
    }

    @Test
    public void testNewRoundRestarts() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Rules rules = mock(Rules.class);
        IOInterface cli = mock(IOInterface.class);
        when(cli.promptPlayAnotherRound()).thenReturn(true, false);
        Game game = spy(new Game(cli, rules, playerOne, playerTwo));

        game.nextRound();
        verify(game, times(2)).nextRound();
        verify(game, times(1)).endGame();
    }



}
