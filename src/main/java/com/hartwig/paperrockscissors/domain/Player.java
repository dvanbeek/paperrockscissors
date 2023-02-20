package com.hartwig.paperrockscissors.domain;

import java.util.Random;

import com.hartwig.paperrockscissors.domain.enums.Move;
import com.hartwig.paperrockscissors.domain.enums.Result;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Player {
    private final Random random = new Random();
    @Getter
    private final String name;
    @Getter
    private int wins = 0;
    @Getter
    private int losses = 0;
    @Getter
    private int ties = 0;

    public Player(final String name) {
        this.name = name;
    }

    public void addResult(final Result result) {
        switch (result) {
            case WIN -> wins++;
            case LOSE -> losses++;
            case TIE -> ties++;
        }
    }

    public Move playRandomMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }

    /**
     * Prints result of past played games from the perspective of this player.
     */
    public void printGameSummary() {
        System.out.printf(
                "Your game results:%n" +
                        "Wins: %s%n" +
                        "Losses: %s%n" +
                        "Ties: %s%n",
                wins, losses, ties
        );
    }
}
