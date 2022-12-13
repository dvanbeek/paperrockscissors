import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Game {

    private UUID UUID;
    private int playerScore;
    private int computerScore;
    private int numberOfDraws;
    private Player player;
    private GameState state;

    public Game(Player player) {
        this.UUID = randomUUID();
        this.player = player;
        this.state = GameState.STARTED;
    }

    public void playerWins() {
        playerScore++;
    }

    public void computerWins() {
        computerScore++;
    }

    public void drawResult() {
        numberOfDraws++;
    }

    public void endGame() {
        this.state = GameState.ENDED;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }
}

