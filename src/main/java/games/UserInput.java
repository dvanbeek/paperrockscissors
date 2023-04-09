package src.main.java.games;

import java.util.List;
import java.util.Scanner;

public class UserInput implements IInputStrategy, AutoCloseable{

    private final Scanner scanner;

    /**
     * UserInput provides a way to receive input from the CLI.
     */
    public UserInput()
    {
        this.scanner = new Scanner(System.in);
    }

    public IChoice choose(List<IChoice> options)
    {
        int number;
        while (true) {
            System.out.print("Enter your choice (int): ");
            String input = scanner.nextLine();
        
            try {
                number = Integer.parseInt(input);
                if (number >=0 && number < options.size())
                {
                    break;
                }
                else
                {
                    System.out.println(
                        "Invalid input: please enter a number within range [0-" + (options.size() - 1) + "]."
                    );
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a number");
                scanner.nextLine();
            }
        }
        return options.get(number);
    }

    public void close()
    {
        scanner.close();
    }
}
