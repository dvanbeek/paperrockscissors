package games.inputs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.Arrays;
import java.util.List;

import games.GameInputOptions;
import games.IChoice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserInputTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testInputStream;
    private ByteArrayOutputStream testOutputStream;

    @BeforeEach
    public void setUpOutput() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @Test
    public void testIfInputReturnsExpectedChoice()
    {
        // Arrange
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());
        String input = "0";
        testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);
        // Act
        UserInput userInput = new UserInput();
        IChoice choice = (GameInputOptions) userInput.choose(inputOptions);
        // Assert
        assertEquals(GameInputOptions.PLAY, choice);
        userInput.close();
    }

    @Test
    public void testIfIncorrectInputIsCatched()
    {
        // Arrange
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());
        String input = "invalid\n1\n";
        testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);
        // Act
        UserInput userInput = new UserInput();
        userInput.choose(inputOptions);
        // Assert
        String actual = testOutputStream.toString();
        String expected = "Enter your choice (int): \nInvalid input: please enter a number"
                        + "\nEnter your choice (int): \n";
        
        assertEquals(expected, actual);
        userInput.close();
    }

    @Test
    public void testIfInputOutOfBoundsIsCatched()
    {
        // Arrange
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());
        String input = "3\n1\n";
        testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);
        // Act
        UserInput userInput = new UserInput();
        userInput.choose(inputOptions);
        // Assert
        String actual = testOutputStream.toString();
        String expected = "Enter your choice (int): \nInvalid input: please enter a number within range [0-"
                        + (inputOptions.size() - 1)
                        + "].\nEnter your choice (int): \n";
        
        assertEquals(expected, actual);
        userInput.close();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
