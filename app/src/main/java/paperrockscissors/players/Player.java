package paperrockscissors.players;

import paperrockscissors.Move;

public interface Player {
    Move makeMove();
    String getName();
}
