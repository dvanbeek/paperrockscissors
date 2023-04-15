package paperrockscissors.players.factories;

import paperrockscissors.io.IOInterface;
import paperrockscissors.players.HumanPlayer;

public class HumanPlayerFactory {

    private final IOInterface io;

    public HumanPlayerFactory(IOInterface io) {
        this.io = io;
    }

    public HumanPlayer create() {
        String name = io.promptPlayerName();
        return new HumanPlayer(name, io);
    }
}
