package games.inputs;

import java.util.List;

import games.IChoice;
import games.IInputStrategy;

/**
 * Class with a fixed input strategy, for players that are convinced
 * sticking to the same choice results in victory.
 */
public class FixedInput implements IInputStrategy{

    private final IChoice choice;

    public FixedInput(IChoice choice)
    {
        this.choice = choice;
    }

    public IChoice choose(List<IChoice> options)
    {
        int index = 0;
        // We do this in case the enum ordinal changes
        for (IChoice option : options) {
            if (this.choice == option)
            {
                break;
            }
            index++;
        }
        return options.get(index);
    }
}