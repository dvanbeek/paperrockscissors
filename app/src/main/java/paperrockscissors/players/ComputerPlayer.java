package paperrockscissors.players;

import paperrockscissors.Move;
import paperrockscissors.players.strategies.RpsStrategy;

public class ComputerPlayer implements Player {

    private final String name;
    private final RpsStrategy strategy;

    public ComputerPlayer(String name, RpsStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public Move makeMove() {
        return strategy.calculateNextMove();
    }

    @Override
    public String getName() {
        return name;
    }
}
