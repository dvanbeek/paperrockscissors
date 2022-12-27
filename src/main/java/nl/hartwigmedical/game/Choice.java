package nl.hartwigmedical.game;

import nl.hartwigmedical.exceptions.InvalidChoiceException;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.String.format;

/***
 * The choices a player can choose from with a beats function per choice
 */
public enum Choice {

    PAPER("paper") {
        @Override
        public boolean beats(Choice otherChoice) {
            return otherChoice == Choice.ROCK;
        }
    },
    ROCK("rock") {
        @Override
        public boolean beats(Choice otherChoice) {
            return otherChoice == Choice.SCISSORS;
        }
    },
    SCISSORS("scissors") {
        @Override
        public boolean beats(Choice otherChoice) {
            return otherChoice == Choice.PAPER;
        }
    };
    public final String label;

    private Choice(String label) {
        this.label = label;
    }

    public static Choice valueOfLabel(String label) throws InvalidChoiceException {
        for (Choice e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        throw new InvalidChoiceException(format("Choice can only be of value %s", values().toString()));
    }

    public static String getLabels() {
        return Arrays.stream(values()).map(Object::toString).map(String::toLowerCase).collect(Collectors.joining(","));
    }

    public abstract boolean beats(Choice otherChoice);
}
