package com.hartwig.paperrockscissors.domain;

import java.util.Arrays;

public enum Choice {

    ROCK, PAPER, SCISSORS, UNKNOWN;

    private Choice beats;

    public static Choice fromString(String value){
        return Arrays.stream(Choice.values())
            .filter(choice -> choice.name().equalsIgnoreCase(value))
            .findFirst()
            .orElse(UNKNOWN);
    }

    boolean beats(Choice choice){
        return this.beats == choice;
    }

    static {
        ROCK.beats = SCISSORS;
        PAPER.beats = ROCK;
        SCISSORS.beats = PAPER;
    }
}
