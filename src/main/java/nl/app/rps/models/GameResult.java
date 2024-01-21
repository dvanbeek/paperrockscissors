package nl.app.rps.models;

import static nl.app.rps.models.GameOption.*;

public enum GameResult {
    LOSS,
    DRAW,
    WIN;

    /**
     * Get the GameResult based on given input players
     *
     * @param player   given GameOption to use as comparison base.
     * @param opponent given GameOption to use as comparison target.
     * @return evaluated comparison
     */
    public static GameResult byInputs(GameOption player, GameOption opponent) {
        if (player == opponent) {
            return DRAW;
        }
        switch (player) {
            case ROCK -> {
                if (opponent == PAPER) {
                    return LOSS;
                }
                return WIN;
            }
            case PAPER -> {
                if (opponent == SCISSORS) {
                    return LOSS;
                }
                return WIN;
            }
            case SCISSORS -> {
                if (opponent == ROCK) {
                    return LOSS;
                }

                return WIN;
            }
            default -> throw new IllegalArgumentException("GameOption " + player.name() + " has not been implemented.");
        }
    }
}
