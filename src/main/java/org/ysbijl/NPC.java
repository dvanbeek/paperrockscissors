package org.ysbijl;

import java.util.Random;

public class NPC extends Player {
    Random random = new Random();

    public String selectRandomMove(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
