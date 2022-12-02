package org.ysbijl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void determineOutcomeGame() {
        Game instance = new Game();
        assertEquals("win", instance.determineOutcomeGame("rock", "scissors"));
        assertEquals("lose", instance.determineOutcomeGame("paper", "scissors"));
        assertEquals("tie", instance.determineOutcomeGame("rock", "rock"));
    }

    @Test
    void incrementScoreGame() {
        Game instance = new Game();
        assertArrayEquals(new int[] {1, 0, 0}, instance.incrementScoreGame("win", new int[] {0, 0, 0}));
        assertArrayEquals(new int[] {1, 1, 0}, instance.incrementScoreGame("lose", new int[] {1, 0, 0}));
        assertArrayEquals(new int[] {1, 1, 3}, instance.incrementScoreGame("tie", new int[] {1, 1, 2}));
    }

    @Test
    void getMessagePlayerMoves() {
        Game instance = new Game();
        assertEquals("User: rock\nComp: scissors\n", instance.getMessagePlayerMoves("rock", "scissors"));
        assertEquals("User: paper\nComp: paper\n", instance.getMessagePlayerMoves("paper", "paper"));
    }

    @Test
    void getMessageScoreGame() {
        Game instance = new Game();
        assertEquals("Thank you for playing!\nWins: 0\nLoses: 0\nTies: 0",
                     instance.getMessageScoreGame(new int[] {0, 0, 0}));
        assertEquals("Thank you for playing!\nWins: 1\nLoses: 1\nTies: 2",
                     instance.getMessageScoreGame(new int[] {1, 1, 2}));
    }
}