package org.ysbijl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void scoreGame() {
        Game instance = new Game();
        assertEquals("win", instance.scoreGame("rock", "scissors"));
        assertEquals("lose", instance.scoreGame("paper", "scissors"));
        assertEquals("tie", instance.scoreGame("rock", "rock"));
    }
}