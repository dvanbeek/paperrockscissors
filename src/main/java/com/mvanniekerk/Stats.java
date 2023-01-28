package com.mvanniekerk;

import com.mvanniekerk.match.Result;

/**
 * Game summary statistics.
 */
public class Stats {
    private int losses = 0;
    private int wins = 0;
    private int draws = 0;

    void addResult(Result result) {
        switch (result) {
            case WIN -> wins++;
            case LOSS -> losses++;
            case DRAW -> draws++;
        }
    }

    @Override
    public String toString() {
        return """
           You won %s times.
           You lost %s times.
           You drew %s times.
           """.formatted(wins, losses, draws);
    }
}
