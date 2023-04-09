package games;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.Arrays;
import java.util.List;

import games.inputs.UserInput;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserInputTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @Test
    public void testIfIncorrectInputIsHandledCorrectly()
    {
        // Arrange
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());
        String input = "0";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        // Act
        UserInput userInput = new UserInput();
        IChoice choice = (GameInputOptions) userInput.choose(inputOptions);
        // Assert
        assertEquals(GameInputOptions.PLAY, choice);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
