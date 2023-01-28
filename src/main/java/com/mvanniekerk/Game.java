package com.mvanniekerk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

/**
 * A game represents a complete rock-paper-scissors session.
 * It has 0-N matches and lasts until the player quits.
 */
public class Game {
    private final List<Match> matches = new ArrayList<>();
    private final Stats stats = new Stats();

    private final Strategy strategy = new Strategy.RandomStrategy();

    public Match match(MatchChoice playerChoice) {
        var aiChoice = strategy.choice(Collections.unmodifiableList(matches));
        var match = new Match(playerChoice, aiChoice);
        matches.add(match);
        stats.addResult(match.getResultForPlayer());
        return match;
    }

    public String getSummary() {
        return stats.toString();
    }
}
