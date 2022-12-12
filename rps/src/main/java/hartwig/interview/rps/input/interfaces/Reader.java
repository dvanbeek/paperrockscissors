package hartwig.interview.rps.input.interfaces;


import hartwig.interview.rps.input.data.InputHand;

/**
 * Provides logic needed to resolve inputs to one of the possible InputHand values
 */
public interface Reader {
    /**
     * @param input can be any value
     * @return InputHand one of the valid input values
     */
    InputHand resolve(String input);
}
