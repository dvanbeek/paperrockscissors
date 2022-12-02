package org.ysbijl;

public class Game {

    public String determineOutcomeGame(String userMove, String compMove) {
        if (userMove.equals(compMove)) {
            return "tie";
        } else if ((userMove.equals("rock") && compMove.equals("scissors")) ||
                   (userMove.equals("scissors") && compMove.equals("paper")) ||
                   (userMove.equals("paper") && compMove.equals("rock"))) { // Winning cases from user perspective
            return "win";
        }
        return "lose"; // only option left, given that userMove and compMove can only be rock, paper, or scissors
    }

    public int[] incrementScoreGame(String gameState, int[] gameScores) {
        switch (gameState) {
            case "win":  gameScores[0]++;
                         break;
            case "lose": gameScores[1]++;
                         break;
            case "tie":  gameScores[2]++;
                         break;
            default:     break;
        }
        return gameScores;
    }

    public String getMessagePlayerMoves(String userMove, String compMove) {
        return String.format("User: %1$s\nComp: %2$s\n", userMove, compMove);
    }

    public String getMessageScoreGame(int[] gameScores) {
        return String.format("Thank you for playing!\nWins: %1$s\nLoses: %2$s\nTies: %3$s",
                             gameScores[0], gameScores[1], gameScores[2]);
    }
}