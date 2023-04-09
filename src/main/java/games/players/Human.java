package games.players;

import java.util.List;

import games.IChoice;
import games.IInputStrategy;
import games.IPlayer;

/**
 * Defines Human player.
 */
public class Human implements IPlayer{

    private final IInputStrategy inputStrategy;

    public Human(IInputStrategy inputStrategy)
    {
        this.inputStrategy = inputStrategy;
    }

    public IChoice choose(List<IChoice> options)
    {
        return inputStrategy.choose(options);
    }

    public boolean isHuman()
    {
        return true;
    }
}
