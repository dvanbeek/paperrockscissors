package nl.app.rps.players;

import nl.app.rps.models.GameOption;
import nl.app.rps.models.Player;

public class Computer implements Player {
    public static final int NUMBER_OF_OPTIONS = 3;

    @Override
    public GameOption getInput() {
        return GameOption.values()[(int) (Math.random() * NUMBER_OF_OPTIONS)];
    }
}
