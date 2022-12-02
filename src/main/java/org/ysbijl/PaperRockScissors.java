package org.ysbijl;

import java.util.Arrays;
import java.util.Scanner;

public class PaperRockScissors {
    public static void main(String[] args) {
        final String[] choices = new String[] {"rock", "paper", "scissors"};
        final String[] playing = new String[] {"yes", "no"};

        boolean keepPlaying = true;
        UPC user = new UPC();
        NPC comp = new NPC();

        while (keepPlaying) {
            user.setMove(user.askUserMove(choices));
            comp.setMove(comp.selectRandomMove(choices));

            Game singleGame = new Game();
            String state = singleGame.scoreGame(user.getMove(), comp.getMove());

            keepPlaying = askUserToKeepPlaying(playing);
        }
    }

    private static boolean askUserToKeepPlaying(String[] options) {
        Scanner userInput = new Scanner(System.in);
        String userChoice = "";
        while (!(Arrays.asList(options).contains(userChoice))) {
            System.out.println("Will you continue playing? (yes/no)");
            userChoice = userInput.nextLine().toLowerCase();
        }
        return userChoice.equals("yes");
    }
}