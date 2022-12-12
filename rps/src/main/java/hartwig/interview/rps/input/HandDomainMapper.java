package hartwig.interview.rps.input;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.input.data.InputHand;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Represents the mapper of InputHand which is a input specific object to domain Hand object
 */
@Component
public class HandDomainMapper {

    /**
     * Resolves the InputHand which is a input specific object to domain Hand object
     * @param hand input
     * @return One of the valid Hand played values resolved from input
     */
    public static Optional<Hand> mapHandToDomain(InputHand hand){
        if(hand == InputHand.Rock) {
            return Optional.of(Hand.Rock);
        }
        else if (hand == InputHand.Paper) {
            return Optional.of(Hand.Paper);
        }
        else if (hand == InputHand.Scissors) {
            return Optional.of(Hand.Scissors);
        }
        return Optional.empty();
    }
}
