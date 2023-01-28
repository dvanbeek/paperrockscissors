package com.mvanniekerk;

public enum Result {
    WIN, LOSS, DRAW;

    static String toString(Result result) {
        return switch (result) {
            case WIN -> "won";
            case LOSS -> "lost";
            case DRAW -> "drew";
        };
    }
}
