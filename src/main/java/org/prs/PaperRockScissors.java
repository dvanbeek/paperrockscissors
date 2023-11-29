package org.prs;

import java.security.SecureRandom;
import java.util.Objects;

/**
 * Represents the shapes (i.e. gestures) that can be used in the game.
 */
public enum PaperRockScissors {
    PAPER,
    ROCK,
    SCISSORS;

    /**
     * Draw a random shape.
     *
     * @return one of the 3 shapes.
     */
    static PaperRockScissors draw() {
        return values()[new SecureRandom().nextInt(3)];
    }

    /**
     * Calculate the score by comparing this shape to the other.
     * <p>
     * Possible scores:
     * <ul>
     *     <li>-1 - the opponent wins</li>
     *     <li>0  - the opponent has the same shape</li>
     *     <li>1  - this shape wins</li>
     * </ul>
     * @param other the opponents shape.
     * @return the score value for this shape.
     */
    int throwAgainst(PaperRockScissors other) {
        Objects.requireNonNull(other);

        if (this.equals(other)) {
            return 0;
        }

        if (this == PAPER) {
            if (other == ROCK) {
                return 1;
            }
            return -1;
        }

        if (this == ROCK) {
            if (other == PAPER) {
                return -1;
            }
            return 1;
        }

        if (other == ROCK) {
            return -1;
        }
        return 1;
    }
}
