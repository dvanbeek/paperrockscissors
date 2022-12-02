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
}