import model.*;

import java.util.*;

public class GameManager {
    private final int maxRounds;
    private final int numberOfComputerPlayers;
    private final int numberOfHumanPlayers;

    private final Player[] players;

    private final ScoreBoard scoreBoard;

    private final Scanner scanner;

    public GameManager(int maxRounds, int numberOfComputerPlayers, int numberOfHumanPlayers, Scanner scanner) {
        if (maxRounds < 0) {
            throw new IllegalArgumentException("The amount of rounds must be a non-negative integer!");
        }
        this.maxRounds = maxRounds;
        if (numberOfComputerPlayers < 0) {
            throw new IllegalArgumentException("The amount of computer players must be a non-negative integer!");
        }
        this.numberOfComputerPlayers = numberOfComputerPlayers;
        if (numberOfHumanPlayers < 0) {
            throw new IllegalArgumentException("The amount of human players must be a non-negative integer!");
        }
        this.numberOfHumanPlayers = numberOfHumanPlayers;
        this.players = new Player[numberOfComputerPlayers + numberOfHumanPlayers];
        this.scoreBoard = new ScoreBoard();
        if (scanner == null) {
            throw new NullPointerException("The passed scanner must be initialized");
        }
        this.scanner = scanner;
    }

    public void play() {
        addPlayers();

        for (int i = 0; i < maxRounds; i++) {
            Round round = new Round(i + 1, players, scoreBoard, scanner);
            round.setPlayerMovesForRound();
            round.calculateRoundResults();
        }

        endGame();
    }

    public void addPlayers() {
        for (int i = 0; i < numberOfComputerPlayers; i++) {
            players[i] = new ComputerPlayer("Computer-" + (i + 1));
            scoreBoard.addPlayer(players[i]);
        }
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            players[i + numberOfComputerPlayers] = new HumanPlayer("Player-" + (i + 1));
            scoreBoard.addPlayer(players[i + numberOfComputerPlayers]);
        }
    }

    private void endGame() {
        scanner.close();
        scoreBoard.printScoreBoard();
        System.exit(0);
    }
}
