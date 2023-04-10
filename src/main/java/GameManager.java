import model.*;

import java.util.*;

public class GameManager {
    private final int maxRounds;
    private final int numberOfComputerPlayers;
    private final int numberOfHumanPlayers;

    private final ComputerPlayer[] computerPlayers;
    private final HumanPlayer[] humanPlayers;

    private final ScoreBoard scoreBoard;

    private final Scanner scanner;

    private final Map<Move, List<Player>> playersByMove;

    public GameManager(int maxRounds, int numberOfComputerPlayers, int numberOfHumanPlayers, Scanner scanner) {
        this.maxRounds = maxRounds;
        this.numberOfComputerPlayers = numberOfComputerPlayers;
        this.numberOfHumanPlayers = numberOfHumanPlayers;
        this.computerPlayers = new ComputerPlayer[numberOfComputerPlayers];
        this.humanPlayers = new HumanPlayer[numberOfHumanPlayers];
        this.scoreBoard = new ScoreBoard();
        this.scanner = scanner;

        playersByMove = new HashMap<>();
        for (Move move : Move.values()) {
            playersByMove.putIfAbsent(move, new ArrayList<>());
        }
    }

    public void play() {
        addPlayers();

        for (int i = 0; i < maxRounds; i++) {
            setPlayerMovesForRound(i + 1);
            calculateRoundScores(i + 1);
        }

        endGame();
    }

    public void calculateRoundScores(int roundIndex) {
        System.out.printf("%n=== RESULTS OF ROUND %d ===%n", roundIndex);

        for (Move move : Move.values()) {
            for (Move counterMove : Move.values()) {
                if (move.winsAgainst(counterMove)
                    && !playersByMove.get(move).isEmpty()
                    && !playersByMove.get(counterMove).isEmpty()) {
                    for (Player player1 : playersByMove.get(move)) {
                        for (Player player2 : playersByMove.get(counterMove)) {
                            this.scoreBoard.incrementScore(player1);
                            System.out.printf("Player %s played %s and won the round against player %s whom played %s%n",
                                    player1.getName(),
                                    player1.getMove(),
                                    player2.getName(),
                                    player2.getMove());
                        }
                    }
                }
            }
        }

        for (List<Player> playerList : playersByMove.values()) {
            playerList.clear();
        }
    }

    public void setPlayerMovesForRound(int roundIndex) {
        System.out.printf("%n=== MOVES FOR ROUND %d ===%n", roundIndex);

        for (int i = 0; i < numberOfComputerPlayers; i++) {
            computerPlayers[i].setRandomMove();
            playersByMove.get(computerPlayers[i].getMove()).add(computerPlayers[i]);
            System.out.printf("Player %s played %s%n", computerPlayers[i].getName(), computerPlayers[i].getMove());
        }

        for (int i = 0; i < numberOfHumanPlayers; i++) {
            getHumanPlayerInput(humanPlayers[i]);
            playersByMove.get(humanPlayers[i].getMove()).add(humanPlayers[i]);
            System.out.printf("Player %s played %s%n", humanPlayers[i].getName(), humanPlayers[i].getMove());
        }
    }

    public void getHumanPlayerInput(HumanPlayer humanPlayer) {
        System.out.println("Make a move for player " + humanPlayer.getName() + " (R for rock, P for paper, S for scissors. Press E to end the game)");

        String moveString = this.scanner.nextLine().strip();

        if (moveString.equalsIgnoreCase("e")) {
            endGame();
        }
        else {
            try {
                humanPlayer.setMove(Move.parseMove(moveString));
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid input!");
                getHumanPlayerInput(humanPlayer);
            }
        }

    }

    public void addPlayers() {
        for (int i = 0; i < numberOfComputerPlayers; i++) {
            computerPlayers[i] = new ComputerPlayer("Computer-" + (i + 1));
            scoreBoard.addPlayer(computerPlayers[i]);
        }
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            humanPlayers[i] = new HumanPlayer("Player-" + (i + 1));
            scoreBoard.addPlayer(humanPlayers[i]);
        }
    }

    public void endGame() {
        scoreBoard.printScoreBoard();
        this.scanner.close();
        System.exit(0);
    }
}
