package src.main.java.games;

import java.util.List;

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
