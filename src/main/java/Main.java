import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxRounds = -1;
        while (maxRounds < 0) {
            System.out.println("Enter the amount of rounds you would like to play:");
            try {
                maxRounds = Integer.parseInt(scanner.nextLine());
                if (maxRounds < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("The amount of rounds must be a non-negative integer!");
            }
        }

        int numberOfComputerPlayers = -1;
        while (numberOfComputerPlayers < 0) {
            System.out.println("Enter the amount of computer players you would like in the game:");
            try {
                numberOfComputerPlayers = Integer.parseInt(scanner.nextLine());
                if (numberOfComputerPlayers < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("The amount of computer players must be a non-negative integer!");
            }
        }

        int numberOfHumanPlayers = -1;
        while (numberOfHumanPlayers < 0) {
            System.out.println("Enter the amount of human players you would like in the game:");
            try {
                numberOfHumanPlayers = Integer.parseInt(scanner.nextLine());
                if (numberOfHumanPlayers < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("The amount of human players must be a non-negative integer!");
            }
        }

        GameManager gameManager = new GameManager(maxRounds, numberOfComputerPlayers, numberOfHumanPlayers, scanner);

        gameManager.play();

        scanner.close();

    }
}
