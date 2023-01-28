package com.mvanniekerk;

import java.util.Random;

public interface Strategy {
    MatchChoice choice(Game game);

    class RandomStrategy implements Strategy {
        Random random = new Random();

        @Override
        public MatchChoice choice(Game game) {
            return MatchChoice.genRandom(random);
        }
    }
}
