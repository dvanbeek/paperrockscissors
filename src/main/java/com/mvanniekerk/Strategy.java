package com.mvanniekerk;

import java.util.List;
import java.util.Random;

public interface Strategy {
    MatchChoice choice(List<Match> matches);

    class RandomStrategy implements Strategy {
        Random random = new Random();

        @Override
        public MatchChoice choice(List<Match> matches) {
            return MatchChoice.genRandom(random);
        }
    }
}
