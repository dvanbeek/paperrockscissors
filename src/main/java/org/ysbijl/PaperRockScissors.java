package org.ysbijl;

public class PaperRockScissors {
    public static void main(String[] args) {
        Player user = new Player();
        Player comp = new Player();

        user.setMove("rock");
        comp.setMove("paper");

        Game singleGame = new Game();
        singleGame.scoreGame(user.getMove(), comp.getMove());
    }


}