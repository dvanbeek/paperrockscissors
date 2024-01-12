package com.hartwigtest.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoveKindTest {

    @Test
    public void testPaperStrongerThanRock() {
        assertTrue(MoveKind.PAPER.isStrongerThan(MoveKind.ROCK));
    }

    @Test
    public void testPaperWeekerThanScissors() {
        assertFalse(MoveKind.PAPER.isStrongerThan(MoveKind.SCISSORS));
    }

    @Test
    public void testScissorsStrongerThanPaper() {
        assertTrue(MoveKind.SCISSORS.isStrongerThan(MoveKind.PAPER));
    }

    @Test
    public void testScissorsWeekerThanRock() {
        assertFalse(MoveKind.SCISSORS.isStrongerThan(MoveKind.ROCK));
    }

    @Test
    public void testRockStrongerThanScissors() {
        assertTrue(MoveKind.ROCK.isStrongerThan(MoveKind.SCISSORS));
    }

    @Test
    public void testRockWeekerThanPaper() {
        assertFalse(MoveKind.ROCK.isStrongerThan(MoveKind.PAPER));
    }
}