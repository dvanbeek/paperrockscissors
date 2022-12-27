package nl.hartwigmedical.game;

import java.util.Random;

/**
 * Simple game strategy based on random
 */
public class SimpleGameStrategy implements GameStrategy{
    @Override
    public Choice applyStrategy() {
        Random random = new Random();
        return  Choice.values()[random.nextInt(Choice.values().length)];
    }
}
