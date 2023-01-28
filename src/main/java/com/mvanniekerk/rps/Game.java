package com.mvanniekerk.rps;

import com.mvanniekerk.rps.match.Round;
import com.mvanniekerk.rps.match.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A game represents a complete rock-paper-scissors session.
 * It has 0-N matches and lasts until the player quits.
 */
public class Game {
    private final List<Round> rounds = new ArrayList<>();
    private final Stats stats = new Stats();

    private final Strategy strategy;

    Game(Strategy strategy) {
        this.strategy = strategy;
    }

    public static Game randomGame() {
        return new Game(new Strategy.RandomStrategy());
    }

    /**
     * Play a round against the AI. The AI will choose an option according to its strategy.
     * The round is recorded so the AI can potentially use it to improve its strategy.
     * The round result is stored in stats so that the stats can be shown when the game ends.
     *
     * @param playerChoice the choice of the player.
     * @return the match, containing the choices of the player and the AI.
     */
    public Round playRound(Move playerChoice) {
        var aiChoice = strategy.choice(viewRounds());
        var round = new Round(playerChoice, aiChoice);
        rounds.add(round);
        stats.addResult(round.getResultForPlayer());
        return round;
    }

    /**
     * @return a summary of the game using the recorded game results.
     */
    public Stats getStats() {
        return stats;
    }

    List<Round> viewRounds() {
        return Collections.unmodifiableList(rounds);
    }
}
