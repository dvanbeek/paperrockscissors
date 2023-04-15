package paperrockscissors;

import paperrockscissors.players.Player;

import java.util.Scanner;

public class CLI {

    private static final Scanner scanner = new Scanner(System.in);

    public Move promptNextMove(String playerName) {
        System.out.printf("%s, please enter your next move.%n", playerName);
        while (true) {
            String nextMoveString = scanner.next();
            Move nextMove = Move.fromString(nextMoveString);
            if (nextMove != null) return nextMove;
            System.out.printf("%s is not a valid move, please try again.%n", nextMoveString);
        }
    }

    public void summarizeRound(Player player1, Player player2, Move move1, Move move2, String winner) {
        System.out.printf("%s threw %s%n", player1.getName(), move1.toString());
        System.out.printf("%s threw %s%n", player2.getName(), move2.toString());
        if (winner == null) {
            System.out.println("Its a draw!");
        } else {
            System.out.printf("The winner is %s%n", winner);
        }
    }

    public boolean promptPlayAnotherRound() {
        System.out.println("Do you want to play another round? (y/n, default: y)");
        String playAnotherRoundString = scanner.next();
        return !playAnotherRoundString.trim().equalsIgnoreCase("n");
    }

    public void announceRoundStart() {
        System.out.println("A new round has started!");
    }

    public void summarizeGame(Player player1, Player player2, int player1Wins, int player2Wins, int draws) {
        System.out.println("The game has ended!");
        System.out.println("These are the final scores:");
        System.out.printf("%s: %d%n", player1.getName(), player1Wins);
        System.out.printf("%s: %d%n", player2.getName(), player2Wins);
        System.out.printf("Draws: %d%n", draws);
        System.out.println("Thank you for playing!");
    }

    public String promptName() {
        System.out.println("Please enter your name");
        while (true) {
            String name = scanner.next();
            if (!name.equals("")) return name;
            System.out.println("That is not a valid name, please try again.");
        }
    }


}
