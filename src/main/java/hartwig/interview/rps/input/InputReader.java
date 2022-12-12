package hartwig.interview.rps.input;

import hartwig.interview.rps.input.data.InputHand;
import hartwig.interview.rps.input.interfaces.Reader;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Reads the input provided and resolves into a InputHand object
 */
@NoArgsConstructor
@Component
public class InputReader implements Reader {
    /**
     * @param input can be any input value
     * @return InputHand object resolved from input
     */
    @Override
    public InputHand resolve(String input) {
        switch(input.toLowerCase())
        {
            case "rock":
                return InputHand.Rock;
            case "paper":
                return InputHand.Paper;
            case "scissors":
                return InputHand.Scissors;
            default:
            return InputHand.PlayAgain;
        }
    }
}
