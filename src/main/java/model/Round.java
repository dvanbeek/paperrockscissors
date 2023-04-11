package model;

import java.util.*;

public class Round {
    private final int roundIndex;

    private final Player[] players;

    private final Scanner scanner;

    private final ScoreBoard scoreBoard;

    public Round(int roundIndex, Player[] players, ScoreBoard scoreBoard, Scanner scanner) {
        if (roundIndex < 1) {
            throw new IllegalArgumentException("Round index must be a positive integer!");
        }
        this.roundIndex = roundIndex;
        if (players == null) {
            throw new NullPointerException("players must be initialized!");
        }
        this.players = players;

        if (scanner == null) {
            throw new NullPointerException("The passed scanner must be initialized");
        }
        this.scanner = scanner;

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

        Arrays.stream(players).forEach(player -> {
            if (player instanceof ComputerPlayer) {
                ((ComputerPlayer) player).setRandomMove();
            }
            else {
                getHumanPlayerInput(player);
            }
            System.out.printf("Player %s played %s%n", player.getName(), player.getCurrentMove());
        });
    }

    public void calculateRoundResults() {
        System.out.printf("%n=== RESULTS OF ROUND %d ===%n", roundIndex);

        for (int i = 0; i < players.length; i++) {
            Player player1 = players[i];
            for (int j = i + 1; j < players.length; j++) {
                Player player2 = players[j];
                if (player1.equals(player2)) {
                    continue;
                }
                if (player1.getCurrentMove().winsAgainst(player2.getCurrentMove())) {
                    scoreBoard.incrementScore(player1);
                    System.out.printf("Player %s played %s and won the round against player %s whom played %s%n",
                            player1.getName(),
                            player1.getCurrentMove(),
                            player2.getName(),
                            player2.getCurrentMove());
                }
                else if (player2.getCurrentMove().winsAgainst(player1.getCurrentMove())) {
                    scoreBoard.incrementScore(player2);
                    System.out.printf("Player %s played %s and won the round against player %s whom played %s%n",
                            player2.getName(),
                            player2.getCurrentMove(),
                            player1.getName(),
                            player1.getCurrentMove());
                }
                else if (player1.getCurrentMove() == player2.getCurrentMove()) {
                    System.out.printf("Both %s and %s played %s and thus have a tie%n",
                            player1.getName(),
                            player2.getName(),
                            player1.getCurrentMove());
                }
            }
        }
    }

    private void getHumanPlayerInput(Player humanPlayer) {
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
