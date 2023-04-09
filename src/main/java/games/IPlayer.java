package src.main.java.games;
import java.util.List;

public interface IPlayer {
    
    /**
     * Lets the player choose one of the available options in the game
     * @param options: List of options where a player needs to choose from.
     * Returns the choice of the player.
     */
    public IChoice choose(List<IChoice> options);

    /**
     * Checks whether implementation is human, used e.g. when a message should
     * be displayed or not.
     * @return
     */
    public boolean isHuman();
}
