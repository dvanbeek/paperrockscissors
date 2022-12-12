package hartwig.interview.rps.domain.ports;

import hartwig.interview.rps.domain.scores.model.GameScore;

/**
 * Represents the basic game action specification
 */
public interface Game {
    /**
     * Plays a round of a game
     */
    void playRound();

    /**
     * Provides information on the game scores
     * @return GameScore end result
     */
    GameScore endGameResult();
}
