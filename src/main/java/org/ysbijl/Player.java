package org.ysbijl;

import java.util.Random;

public class Player {
    String move;
    Random random = new Random();

    public String getMove() {
        return move;
    }

    public void setMove(String newMove) {
        move = newMove;
    }

    public String selectRandomMove(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
