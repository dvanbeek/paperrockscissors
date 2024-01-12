package com.hartwigtest.game;

import java.util.Random;

import com.hartwigtest.model.MoveKind;

final class PlayerComputer extends PlayerAbstract {
    static String computerPlayerName = "ROBOT";
    static int computerPlayerNumber = 0;
    static Random random = new Random();

    public PlayerComputer() {
        super(computerPlayerName + Integer.toString(++computerPlayerNumber));
    }

    @Override
    public MoveKind move() {
        switch (random.nextInt(MoveKind.values().length)) {
            case 0:
                return MoveKind.ROCK;
            case 1:
                return MoveKind.PAPER;
            case 2:
                return MoveKind.SCISSORS;
        }
        return null;
    }
}