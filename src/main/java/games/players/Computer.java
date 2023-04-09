package games.players;

import java.util.List;

import games.IChoice;
import games.IInputStrategy;
import games.IPlayer;

/**
 * Defines Computer player.
 */
public class Computer implements IPlayer{
    
    private final IInputStrategy inputStrategy;

    public Computer(IInputStrategy inputStrategy)
    {
        this.inputStrategy = inputStrategy;
    }

    public IChoice choose(List<IChoice> options)
    {
        return inputStrategy.choose(options);
    }

    public boolean isHuman()
    {
        return false;
    }
}
