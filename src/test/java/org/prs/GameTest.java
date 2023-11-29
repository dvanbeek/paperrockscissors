package org.prs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Game testObject;

    @BeforeEach
    void setUp() {
        testObject = new Game();
    }

    @Test
    void testReadInput() {
        Object[][] input = {
                {"", Optional.empty()},
                {" ", Optional.empty()},
                {null, Optional.empty()},
                {"X", Optional.empty()},
                {"P", Optional.of(PaperRockScissors.PAPER)},
                {"R", Optional.of(PaperRockScissors.ROCK)},
                {"s", Optional.of(PaperRockScissors.SCISSORS)},
                {"PaPer", Optional.of(PaperRockScissors.PAPER)},
                {"ROCK", Optional.of(PaperRockScissors.ROCK)},
                {"scissors", Optional.of(PaperRockScissors.SCISSORS)},
        };

        for (var tuple : input) {
            assertEquals(tuple[1], testObject.readInput((String) tuple[0]));
        }
    }

    @Test
    void computeScore() {
        assertEquals(0, testObject.getHumanScore());
        assertEquals(0, testObject.getComputerScore());

        testObject.computeScore(PaperRockScissors.PAPER, PaperRockScissors.PAPER);
        assertEquals(0, testObject.getHumanScore());
        assertEquals(0, testObject.getComputerScore());

        testObject.computeScore(PaperRockScissors.PAPER, PaperRockScissors.ROCK);
        assertEquals(0, testObject.getHumanScore());
        assertEquals(1, testObject.getComputerScore());

        testObject.computeScore(PaperRockScissors.ROCK, PaperRockScissors.PAPER);
        assertEquals(1, testObject.getHumanScore());
        assertEquals(1, testObject.getComputerScore());
    }
}
