package com.mvanniekerk;

public class Match {
    private final MatchChoice playerChoice;
    private final MatchChoice aiChoice;

    public Match(MatchChoice playerChoice, MatchChoice aiChoice) {
        this.playerChoice = playerChoice;
        this.aiChoice = aiChoice;
    }

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
