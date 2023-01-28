package com.mvanniekerk;

import com.mvanniekerk.match.Round;
import com.mvanniekerk.match.Move;

import java.util.List;
import java.util.Random;

public interface Strategy {

    /**
     * Make a choice for a move. The AI has access to all previous rounds which it can use
     * to potentially improve the strategy.
     * @param rounds All previous rounds.
     * @return the AI choice.
     */
    Move choice(List<Round> rounds);

    /**
     * This AI always makes a random choice, regardless of the previous rounds.
     */
    class RandomStrategy implements Strategy {
        private final Random random = new Random();

        @Override
        public Move choice(List<Round> rounds) {
            var num = random.nextInt(0, 3);
            return Move.fromInt(num);
        }
    }
}
