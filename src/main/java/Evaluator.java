import java.util.Random;

public class Evaluator {

    private static final int AMOUNT_OF_DIFFERENT_MOVES = 3;

    public static void evaluatePlayerMove(Game game, Move playerMove) {
        Move computerMove = generateComputerMove();
        evaluateWinner(game, playerMove, computerMove);
    }

    public static Move generateComputerMove() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(AMOUNT_OF_DIFFERENT_MOVES);
        return Move.values()[randomNumber];
    }

    public static void evaluateWinner(Game game, Move playerMove, Move computerMove) {
        System.out.print("Player uses: " + playerMove +"\n");
        System.out.print("Computer uses: " + computerMove +"\n");
        if (playerMove == computerMove) {
            game.drawResult();
            System.out.print("It's a draw!\n");
        } else if (playerMove == Move.ROCK && computerMove == Move.SCISSORS) {
            game.playerWins();
            System.out.print("Player wins!\n");
        } else if (playerMove == Move.ROCK && computerMove == Move.PAPER) {
            game.computerWins();
            System.out.print("Computer wins!\n");
        } else if (playerMove == Move.PAPER && computerMove == Move.ROCK) {
            game.playerWins();
            System.out.print("Player wins!\n");
        } else if (playerMove == Move.PAPER && computerMove == Move.SCISSORS) {
            game.computerWins();
            System.out.print("Computer wins!\n");
        } else if (playerMove == Move.SCISSORS && computerMove == Move.ROCK) {
            game.computerWins();
            System.out.print("Computer wins!\n");
        } else if (playerMove == Move.SCISSORS && computerMove == Move.PAPER) {
            game.playerWins();
            System.out.print("Player wins!\n");
        }
    }

    public static void showScore(Game game) {
        System.out.print(
            "The score is, Player: " + game.getPlayerScore() + " Computer: " + game.getComputerScore() + " Draws: " + game.getNumberOfDraws());
    }
}
