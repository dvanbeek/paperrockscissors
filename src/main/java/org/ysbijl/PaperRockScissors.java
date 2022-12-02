package org.ysbijl;

public class PaperRockScissors {
    public static void main(String[] args) {
        final String[] choices = new String[] {"rock", "paper", "scissors"};
        final String[] playing = new String[] {"yes", "no"};

        boolean keepPlaying = true;
        int[] scores = new int[] {0, 0, 0}; // Wins, Loses, Ties from user perspective
        Game prsGame = new Game();
        UPC user = new UPC();
        NPC comp = new NPC();

        while (keepPlaying) {
            user.setMove(user.askUserChoice(choices, "What move will you make? (rock/paper/scissors)"));
            comp.setMove(comp.selectRandomMove(choices));

            System.out.print(prsGame.getMessagePlayerMoves(user.getMove(), comp.getMove()));
            String state = prsGame.determineOutcomeGame(user.getMove(), comp.getMove());
            scores = prsGame.incrementScoreGame(state, scores);

            keepPlaying = user.askUserChoice(playing, "Will you continue playing? (yes/no)").equals("yes");
        }
        System.out.print(prsGame.getMessageScoreGame(scores));
    }
}