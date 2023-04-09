package src.main.java.games;

import java.util.List;

public interface IInputStrategy {
    
    /**
     * Choose one of the options from the list of available choices.
     * @param choices List of choices
     * @return Chosen IChoice.
     */
    public IChoice choose(List<IChoice> choices);
}
