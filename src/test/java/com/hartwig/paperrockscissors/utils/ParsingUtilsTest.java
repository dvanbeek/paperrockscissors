package com.hartwig.paperrockscissors.utils;

import com.hartwig.paperrockscissors.domain.enums.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParsingUtilsTest {
    @Test
    void parseMoveFromInput_lowercase() {
        assertEquals(Move.ROCK, ParsingUtils.parseMoveFromInput("rock"));
    }

    @Test
    void parseMoveFromInput_caseInsensitive() {
        assertEquals(Move.PAPER, ParsingUtils.parseMoveFromInput("PaPEr"));
    }

    @Test
    void parseMoveFromInput_whitespaces() {
        assertEquals(Move.SCISSORS, ParsingUtils.parseMoveFromInput(" scissors "));
    }

    @Test
    void parseMoveFromInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> ParsingUtils.parseMoveFromInput("QUIT"));
    }
}