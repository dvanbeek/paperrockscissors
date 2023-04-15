package paperrockscissors.rules;

import paperrockscissors.Move;

public class DefaultRules implements Rules {
    @Override
    public int decideWinner(Move move1, Move move2) {
        if (move1 == move2) return 0;
        if (move1 == Move.ROCK && move2 == Move.SCISSORS ||
                move1 == Move.PAPER && move2 == Move.ROCK ||
                move1 == Move.SCISSORS && move2 == Move.PAPER) {
            return 1;
        }
        return 2;
    }
}
