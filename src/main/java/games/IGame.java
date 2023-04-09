package games;

public interface IGame {

    /**
     * Plays a game and returns if the first player has won or not.
     */
    public ResultsEnum play();

    /**
     * Outputs the options in the CLI
     */
    public void displayOptions();
}
