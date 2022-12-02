package org.ysbijl;

public class PaperRockScissors {
    public static void main(String[] args) {
        String user = "rock";
        String comp = "scissors";

        Game singleGame = new Game();
        singleGame.scoreGame(user, comp);
    }


}