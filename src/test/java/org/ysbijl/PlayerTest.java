package org.ysbijl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMove() {
        Player instance = new Player();
        assertEquals(instance.getMove(), "");

        String move = "move";
        instance.move = move;
        assertEquals(instance.getMove(), move);
    }

    @Test
    void setMove() {
        String move = "move";
        Player instance = new Player();
        instance.setMove(move);
        assertEquals(instance.move, move);
    }
}