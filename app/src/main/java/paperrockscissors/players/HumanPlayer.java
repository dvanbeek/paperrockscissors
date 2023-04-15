package paperrockscissors.players;

import paperrockscissors.CLI;
import paperrockscissors.Move;

public class HumanPlayer implements Player {

    private final CLI cli;
    private final String name;

    public HumanPlayer(String name, CLI cli) {
        this.name = name;
        this.cli = cli;
    }
    @Override
    public Move makeMove() {
        return cli.promptNextMove(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
