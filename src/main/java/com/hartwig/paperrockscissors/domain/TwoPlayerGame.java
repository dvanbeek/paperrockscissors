package com.hartwig.paperrockscissors.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.util.EnumSet.of;

public record TwoPlayerGame(List<Round> rounds) implements RockPaperScissors {

    public TwoPlayerGame() {
        this(new ArrayList<>());
    }

    @Override
    public EnumSet<Choice> fetchPossibleChoice() {
        return EnumSet.complementOf(of(Choice.UNKNOWN));
    }

    @Override
    public void playRound(Round round) {
        onlyAllowTwoMovesPerRound(round.movesPlayed());
        rounds.add(round);
    }

    @Override
    public Score determineScore() {
        return new Score(determineResults());
    }

    private void onlyAllowTwoMovesPerRound(List<Move> moves) {
        if (moves.size() != 2) {
            throw new IllegalStateException("A two player game can only be played by 2 players");
        }
    }

    private Map<Player, GameResults> determineResults() {
        HashMap<Player, GameResults> results = new HashMap<>();
        for (Round round : rounds) {
            List<Move> moves = round.movesPlayed();
            Move moveOne = moves.get(0);
            Move moveTwo = moves.get(1);
            results.computeIfAbsent(moveOne.player(), unused -> new GameResults(0,0,0));
            results.computeIfAbsent(moveTwo.player(), unused -> new GameResults(0,0,0));
            if (moveOne.choice().beats(moveTwo.choice())) {
                results.computeIfPresent(moveOne.player(), incrementWon());
                results.computeIfPresent(moveTwo.player(), incrementLost());
            } else if (moveTwo.choice().beats(moveOne.choice())) {
                results.computeIfPresent(moveTwo.player(), incrementWon());
                results.computeIfPresent(moveOne.player(), incrementLost());
            } else {
                results.computeIfPresent(moveTwo.player(), incrementTied());
                results.computeIfPresent(moveOne.player(), incrementTied());
            }
        }
        return results;
    }

    private static BiFunction<Player, GameResults, GameResults> incrementTied() {
        return (k, v) -> new GameResults(v.won(), v.lost(), v.tied() + 1);
    }

    private static BiFunction<Player, GameResults, GameResults> incrementLost() {
        return (k, v) -> new GameResults(v.won(), v.lost() + 1, v.tied());
    }

    private static BiFunction<Player, GameResults, GameResults> incrementWon() {
        return (k, v) -> new GameResults(v.won() + 1, v.lost(), v.tied());
    }
}
