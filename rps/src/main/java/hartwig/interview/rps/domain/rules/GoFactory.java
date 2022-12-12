package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;

import java.util.Optional;

/**
 * This object is responsibe for the creation of a specific OpenHand implementation instance
 * It contains logic necessary to decide which implementation of the interface should be chosen
 */
public class GoFactory {
    /**
     * @param hand Specifies the hand played
     * @return Optional of OpenHand or an empty if Hand played doesn't correspond to any of the current implementations
     */
    public static Optional<OpenHand> openHand(Hand hand){
        if(hand == Hand.Rock)
            return Optional.of(new Rock());
        else if (hand == Hand.Scissors)
            return Optional.of(new Scissors());
        else if (hand == Hand.Paper)
            return Optional.of(new Paper());
        return Optional.empty();
    }
}
