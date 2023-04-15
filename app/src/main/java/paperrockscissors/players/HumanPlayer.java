package paperrockscissors.players;

import paperrockscissors.io.IOInterface;
import paperrockscissors.Move;

public class HumanPlayer implements Player {

    private final IOInterface io;
    private final String name;

    public HumanPlayer(String name, IOInterface io) {
        this.name = name;
        this.io = io;
    }
    @Override
    public Move makeMove() {
        return io.promptNextMove(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
