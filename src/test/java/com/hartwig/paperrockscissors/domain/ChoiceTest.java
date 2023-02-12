package com.hartwig.paperrockscissors.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChoiceTest {

    @Test
    void fromString_shouldReturnChoice() {
        assertEquals(Choice.ROCK, Choice.fromString("rock"));
        assertEquals(Choice.PAPER, Choice.fromString("paper"));
        assertEquals(Choice.SCISSORS, Choice.fromString("scissors"));
        assertEquals(Choice.UNKNOWN, Choice.fromString("unrelated string"));
    }

    @Test
    void beats_shouldReturnTrueIfBeatsOpponent() {
        assertTrue(Choice.ROCK.beats(Choice.SCISSORS));
        assertTrue(Choice.PAPER.beats(Choice.ROCK));
        assertTrue(Choice.SCISSORS.beats(Choice.PAPER));
    }

    @Test
    void beats_shouldReturnFalseIfDoesNotBeatOpponent() {
        assertFalse(Choice.ROCK.beats(Choice.PAPER));
        assertFalse(Choice.PAPER.beats(Choice.SCISSORS));
        assertFalse(Choice.SCISSORS.beats(Choice.ROCK));
    }
}
