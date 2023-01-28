package com.mvanniekerk;

/**
 * A game represents a complete rock-paper-scissors session.
 * It has 0-N matches and lasts until the player quits.
 */
public class Game {
    private int wins = 0;
    private int draws = 0;
    private int losses = 0;

    private final Strategy strategy = new Strategy.RandomStrategy();

    public Result match(MatchChoice playerChoice) {
        var aiChoice = strategy.choice(this);
        if (aiChoice.equals(playerChoice)) {
            draws++;
            return Result.DRAW;
        }
        if (aiChoice.beats(playerChoice)) {
            losses++;
            return Result.LOSS;
        } else {
            wins++;
            return Result.WIN;
        }
    }

    public String getSummary() {
        return """
           You won %s times.
           You lost %s times.
           You drew %s times.
           """.formatted(wins, losses, draws);
    }
}
