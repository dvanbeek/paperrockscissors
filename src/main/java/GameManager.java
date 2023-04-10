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

        this.playersByMove = new HashMap<>();
        for (Move move : Move.values()) {
            this.playersByMove.putIfAbsent(move, new ArrayList<>());
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
                if (move == counterMove
                    && playersByMove.get(move).size() > 1) {
                    handleTieOutput(move, playersByMove.get(move));
                }
                else if (move.winsAgainst(counterMove)
                    && !playersByMove.get(move).isEmpty()
                    && !playersByMove.get(counterMove).isEmpty()) {
                    handleRoundWin(playersByMove.get(move), playersByMove.get(counterMove));
                }
            }
        }

        playersByMove.values().forEach(List::clear);
    }

    private void handleRoundWin(List<Player> winningPlayers, List<Player> losingPlayers) {
        for (Player winner : winningPlayers) {
            for (Player loser : losingPlayers) {
                scoreBoard.incrementScore(winner);
                System.out.printf("Player %s played %s and won the round against player %s whom played %s%n",
                        winner.getName(),
                        winner.getCurrentMove(),
                        loser.getName(),
                        loser.getCurrentMove());
            }
        }
    }

    private void handleTieOutput(Move move, List<Player> playerList) {
        for (Player player : playerList) {
            System.out.print(player.getName() + ", ");
        }
        System.out.printf(" played %s and have a tie%n", move.toString());
    }

    public void setPlayerMovesForRound(int roundIndex) {
        System.out.printf("%n=== MOVES FOR ROUND %d ===%n", roundIndex);

        Arrays.stream(computerPlayers).forEach(computerPlayer -> {
            computerPlayer.setRandomMove();
            playersByMove.get(computerPlayer.getCurrentMove()).add(computerPlayer);
            System.out.printf("Player %s played %s%n", computerPlayer.getName(), computerPlayer.getCurrentMove());
        });

        Arrays.stream(humanPlayers).forEach(humanPlayer -> {
            getHumanPlayerInput(humanPlayer);
            playersByMove.get(humanPlayer.getCurrentMove()).add(humanPlayer);
            System.out.printf("Player %s played %s%n", humanPlayer.getName(), humanPlayer.getCurrentMove());
        });
    }

    public void getHumanPlayerInput(HumanPlayer humanPlayer) {
        System.out.printf("Make a move for player %s (R for rock, P for paper" +
                ", S for scissors. Press E to end the game)", humanPlayer.getName());

        String moveString = scanner.nextLine().strip();

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
        scanner.close();
        System.exit(0);
    }
}
