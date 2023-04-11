package model;

import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    public void setRandomMove() {
        setMove(Move.values()[random.nextInt(Move.values().length)]);
    }
}
