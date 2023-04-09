package src.main.java.games;

import java.util.List;

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
