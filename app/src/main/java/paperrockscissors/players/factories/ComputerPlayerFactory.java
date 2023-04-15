package paperrockscissors.players.factories;

import paperrockscissors.players.ComputerPlayer;
import paperrockscissors.players.strategies.RandomStrategy;

public class ComputerPlayerFactory {
    public ComputerPlayer create(ComputerPlayerBlueprint blueprint, String name) {
        switch (blueprint) {
            default -> throw new IllegalArgumentException("Invalid blueprint!");
            case RANDOM_COMPUTER_PLAYER -> {return new ComputerPlayer(name, new RandomStrategy());}
            // add more cases if more computer strategies become available.
        }
    }
}

