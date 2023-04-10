package model;

import java.util.*;

public class Round {
    private final int roundIndex;

    private final ComputerPlayer[] computerPlayers;
    private final HumanPlayer[] humanPlayers;

    private final Scanner scanner;

    private final Map<Move, List<Player>> playersByMove;

    private final ScoreBoard scoreBoard;

    public Round(int roundIndex, ComputerPlayer[] computerPlayers, HumanPlayer[] humanPlayers,
                 ScoreBoard scoreBoard, Scanner scanner) {
        if (roundIndex < 1) {
            throw new IllegalArgumentException("Round index must be a positive integer!");
        }
        this.roundIndex = roundIndex;
        if (computerPlayers == null) {
            throw new NullPointerException("Computer players must be initialized!");
        }
        this.computerPlayers = computerPlayers;
        if (humanPlayers == null) {
            throw new NullPointerException("Human players must be initialized!");
        }
        this.humanPlayers = humanPlayers;

        if (scanner == null) {
            throw new NullPointerException("The passed scanner must be initialized");
        }
        this.scanner = scanner;

        this.playersByMove = new HashMap<>();
        for (Move move : Move.values()) {
            this.playersByMove.putIfAbsent(move, new ArrayList<>());
        }

        if (scoreBoard == null) {
            throw new NullPointerException("ScoreBoard must be initialized");
        }
        this.scoreBoard = scoreBoard;
    }

    /**
     * Sets randomly selected moves to computer players
     * and asks for user input of the human players
     */
    public void setPlayerMovesForRound() {
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

    public void calculateRoundResults() {
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
                    handleWinOutput(playersByMove.get(move), playersByMove.get(counterMove));
                }
            }
        }
    }

    private void handleWinOutput(List<Player> winningPlayers, List<Player> losingPlayers) {
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

    private void getHumanPlayerInput(HumanPlayer humanPlayer) {
        System.out.printf("Make a move for player %s (R for rock, P for paper" +
                ", S for scissors. Press E to end the game)%n", humanPlayer.getName());

        String moveString = scanner.nextLine().strip();

        if (moveString.equalsIgnoreCase("e")) {
            endGame();
        }
        try {
            humanPlayer.setMove(Move.parseMove(moveString));
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a valid input!");
            getHumanPlayerInput(humanPlayer);
        }
    }

    private void endGame() {
        scanner.close();
        scoreBoard.printScoreBoard();
        System.exit(0);
    }

}
