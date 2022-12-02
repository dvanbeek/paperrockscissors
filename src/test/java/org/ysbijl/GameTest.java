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
}