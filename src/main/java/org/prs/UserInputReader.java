package org.prs;

import java.util.Objects;
import java.util.Optional;

interface UserInputReader {
    /**
     * Maps game input into one of the 3 shapes.
     * <p>
     * Input can be uppercase or lowercase and/or only the starting letter.
     *
     * @param input Possibly one of the paper, rock or scissors shapes.
     * @return the, optionally empty, shape.
     */
    default Optional<PaperRockScissors> readInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return Optional.empty();
        }

        var gesture = input.toLowerCase();
        for (var value : PaperRockScissors.values()) {
            var shape = value.toString().toLowerCase();
            if (shape.equals(gesture) || shape.startsWith(gesture)) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }
}
