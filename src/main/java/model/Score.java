package model;

public record Score(Player player, int score) {
    public Score {
        if (player == null) {
            throw new NullPointerException("Player must be initialized!");
        }
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative!");
        }
    }
}
