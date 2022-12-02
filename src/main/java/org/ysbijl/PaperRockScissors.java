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
            user.setMove(user.askUserChoice(choices, "What move will you make? (rock/paper/scissors)"));
            comp.setMove(comp.selectRandomMove(choices));

            Game singleGame = new Game();
            String state = singleGame.scoreGame(user.getMove(), comp.getMove());

            keepPlaying = user.askUserChoice(playing, "Will you continue playing? (yes/no)").equals("yes");
        }
    }
}