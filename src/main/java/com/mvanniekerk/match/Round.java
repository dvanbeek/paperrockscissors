package com.mvanniekerk.match;

public class Round {
    private final Move playerChoice;
    private final Move aiChoice;

    public Round(Move playerMove, Move aiMove) {
        this.playerChoice = playerMove;
        this.aiChoice = aiMove;
    }

    /**
     * @return the match result from the perspective of the player.
     */
    public Result getResultForPlayer() {
        if (aiChoice.equals(playerChoice)) {
            return Result.DRAW;
        }
        return aiChoice.beats(playerChoice) ? Result.LOSS : Result.WIN;
    }

    @Override
    public String toString() {
        return "You chose %s, the AI chose %s, so you %s."
                .formatted(playerChoice.toString(), aiChoice.toString(), Result.toString(getResultForPlayer()));
    }
}
