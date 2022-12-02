package org.ysbijl;

public class PaperRockScissors {
    public static void main(String[] args) {
        final String[] choices = new String[] {"rock", "paper", "scissors"};

        UPC user = new UPC();
        NPC comp = new NPC();

        user.setMove(user.askUserMove(choices));
        comp.setMove(comp.selectRandomMove(choices));

        Game singleGame = new Game();
        String state = singleGame.scoreGame(user.getMove(), comp.getMove());
    }


}