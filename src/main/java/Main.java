import java.nio.channels.ScatteringByteChannel;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

public class Main {

    private final static String QUIT_COMMAND = "Q";

    public static void main(String[] args) {
        System.out.print("Welcome to the game Rock Paper Scissors.\n");
        System.out.print("Enter your Player's name:\n");

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(scanner.nextLine());

        // Start new game
        Game game = new Game(player);
        System.out.print("New game started, to quit press: \"q\"\n");
        while (game.getState() != GameState.ENDED) {

            // Prompt the player to enter their move (rock, paper, or scissors)
            System.out.print("Enter your move (rock, paper, or scissors): \n");
            String inputMove = scanner.nextLine().toUpperCase();
            System.out.print(inputMove +"\n");

            // Check if player wants to quit the game
            if (Objects.equals(inputMove, QUIT_COMMAND)) {
                game.setState(GameState.ENDED);
            }
            else if (isValidEnum(Move.class, inputMove)) {
                Move playerMove = Move.valueOf(inputMove);
                Evaluator.evaluatePlayerMove(game, playerMove);
            }
            // Redirect player to prompt for invalid input
            else {
                System.out.print("Invalid input, please try again.\n");
            }
        }
        System.out.print("Thank you for playing.\n");
        Evaluator.showScore(game);

    }


}
