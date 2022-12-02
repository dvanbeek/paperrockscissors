package org.ysbijl;

public class Game {

    public String scoreGame(String userMove, String compMove) {
        if (userMove.equals(compMove)){
            return "tie";
        } else if ((userMove.equals("rock") && compMove.equals("scissors")) ||
                   (userMove.equals("scissors") && compMove.equals("paper")) ||
                   (userMove.equals("paper") && compMove.equals("rock"))) { // Winning cases from user perspective
            return "win";
        }
        return "lose";
    }
}
