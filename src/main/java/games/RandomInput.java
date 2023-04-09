package src.main.java.games;

import java.util.List;
import java.util.Random;

/**
 * Class to choose a random input from the available options using
 * java.util.random library.
 */
public class RandomInput implements IInputStrategy{

    private final Random random = new Random();

    public IChoice choose(List<IChoice> options)
    {
        return options.get(random.nextInt(options.size()));
    }
}
