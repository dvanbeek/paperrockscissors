package org.prs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperRockScissorsTest {

    @Test
    void draw() {
        assertNotNull(PaperRockScissors.draw());
    }

    @Test
    void throwAgainst() {
        assertEquals(PaperRockScissors.ROCK.throwAgainst(PaperRockScissors.PAPER),  -1);
        assertEquals(PaperRockScissors.ROCK.throwAgainst(PaperRockScissors.ROCK),  0);
        assertEquals(PaperRockScissors.ROCK.throwAgainst(PaperRockScissors.SCISSORS),  1);

        assertEquals(PaperRockScissors.PAPER.throwAgainst(PaperRockScissors.PAPER),  0);
        assertEquals(PaperRockScissors.PAPER.throwAgainst(PaperRockScissors.ROCK),  1);
        assertEquals(PaperRockScissors.PAPER.throwAgainst(PaperRockScissors.SCISSORS),  -1);

        assertEquals(PaperRockScissors.SCISSORS.throwAgainst(PaperRockScissors.PAPER),  1);
        assertEquals(PaperRockScissors.SCISSORS.throwAgainst(PaperRockScissors.ROCK),  -1);
        assertEquals(PaperRockScissors.SCISSORS.throwAgainst(PaperRockScissors.SCISSORS),  0);
    }
}