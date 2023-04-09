package games.inputs;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import games.IChoice;
import games.IInputStrategy;

/**
 * Handles UserInput using the java.util.Scanner input source.
 */
public class UserInput implements IInputStrategy, Closeable{

    private final Scanner scanner;

    /**
     * UserInput provides a way to receive input from the CLI.
     */
    public UserInput()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lets the user choose an option from the list of provided choices.
     * The choices are presented as a numbered list to the user where
     * the user selects an option by providing the number of the option.
     * The input is checked whether it is valid and in range and retries
     * untill a user provides a valid input.
     * 
     * Returns the choice made by the user
     */
    public IChoice choose(List<IChoice> options)
    {
        int number;
        while (true) {
            System.out.println("Enter your choice (int): ");
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
            }
        }
        return options.get(number);
    }

    public void close()
    {
        scanner.close();
    }
}
