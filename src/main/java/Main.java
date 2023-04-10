import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxRounds = getIntegerUserInput(
                "Enter the amount of rounds you would like to play:",
                "The amount of rounds must be a non-negative integer!",
                scanner);

        int numberOfComputerPlayers = getIntegerUserInput(
                "Enter the amount of computer players you would like in the game:",
                "The amount of computer players must be a non-negative integer!",
                scanner
        );

        int numberOfHumanPlayers = getIntegerUserInput(
                "Enter the amount of human players you would like in the game:",
                "The amount of human players must be a non-negative integer!",
                scanner
        );

        GameManager gameManager = new GameManager(maxRounds, numberOfComputerPlayers, numberOfHumanPlayers, scanner);
        gameManager.play();

        scanner.close();
    }

    private static int getIntegerUserInput(String message, String exceptionMessage, Scanner scanner) {
        int result = -1;
        while (result < 0) {
            System.out.println(message);
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println(exceptionMessage);
            }
        }
        return result;
    }
}
