package paperrockscissors.rules;

import paperrockscissors.Move;

public interface Rules {

    int decideWinner(Move move1, Move move2);
}
