package com.hartwigtest.model;

public enum MoveKind {
    ROCK {
        @Override
        public boolean isStrongerThan(MoveKind other) {
            return other == SCISSORS;
        }
    },
    PAPER {
        @Override
        public boolean isStrongerThan(MoveKind other) {
            return other == ROCK;
        }
    },
    SCISSORS {
        @Override
        public boolean isStrongerThan(MoveKind other) {
            return other == PAPER;
        }
    };

    public boolean isStrongerThan(MoveKind other) {
        return false;
    }
}
