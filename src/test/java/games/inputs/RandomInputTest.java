package games.inputs;

import java.util.Arrays;
import java.util.List;

import games.GameInputOptions;
import games.IChoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;;

public class RandomInputTest {
    
    @Test
    public void testIfRandomInputReturnsChoice()
    {
        RandomInput input = new RandomInput();
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());
        IChoice choice = input.choose(inputOptions);
        assertNotNull(choice);
    }
}
