package hartwig.interview.rps.input;

import hartwig.interview.rps.RPSApplication;
import hartwig.interview.rps.input.interfaces.Reader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RPSApplication.class, initializers = ConfigDataApplicationContextInitializer.class)
class InputReaderTest {

    @Autowired
    Reader tranformer;

    @Test
    public void resolveInput_InputNotValid_ReturnsInvalid(){
        var result = tranformer.resolve("1");
        assertEquals(result.name(), "PlayAgain");
    }

    @Test
    public void resolveInput_Rock_ReturnsRock(){
        var result = tranformer.resolve("rock");
        assertEquals(result.name(), "Rock");
    }

    @Test
    public void resolveInput_Paper_ReturnsPaper(){
        var result = tranformer.resolve("paper");
        assertEquals(result.name(), "Paper");
    }
    @Test
    public void resolveInput_Scissors_ReturnsScissors(){
        var result = tranformer.resolve("scissors");
        assertEquals(result.name(), "Scissors");
    }

}