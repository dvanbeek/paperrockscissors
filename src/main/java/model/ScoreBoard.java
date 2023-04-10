package model;

import java.util.*;

public class ScoreBoard {
    private final Map<Player, Integer> scoreMap;

    public ScoreBoard() {
        this.scoreMap = new HashMap<>();
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new NullPointerException("Player must be initialized");
        }
        scoreMap.putIfAbsent(player, 0);
    }

    public void incrementScore(Player player) {
        addPlayer(player);
        this.scoreMap.put(player, this.scoreMap.get(player) + 1);
    }

    public List<Score> getOrderedScoreList() {
        List<Score> orderedScoreList = new ArrayList<>();

        for (Map.Entry<Player, Integer> entry : scoreMap.entrySet()) {
            orderedScoreList.add(new Score(entry.getKey(), entry.getValue()));
        }

        orderedScoreList.sort(Comparator.comparing(Score::score).reversed());
        return orderedScoreList;
    }

    public void printScoreBoard() {
        List<Score> scoreList = getOrderedScoreList();

        System.out.println("\n=== RESULTS ===\n");
        int rank = 1;
        for (Score score : scoreList) {
            System.out.printf("At rank %d stands player %s with score %d%n", rank++, score.player().getName(), score.score());
        }
    }



}
