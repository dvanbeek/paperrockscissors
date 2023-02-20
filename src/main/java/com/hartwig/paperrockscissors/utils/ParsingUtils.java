package com.hartwig.paperrockscissors.utils;

import com.hartwig.paperrockscissors.domain.enums.Move;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ParsingUtils {
    public static Move parseMoveFromInput(final String input) throws IllegalArgumentException {
        return Move.valueOf(input.trim().toUpperCase());
    }
}
