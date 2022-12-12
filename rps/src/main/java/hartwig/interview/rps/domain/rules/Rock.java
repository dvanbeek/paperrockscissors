package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.data.HandResult;
import org.springframework.stereotype.Component;

/**
 * Represents a rock implementation of hand played
 */
@Component
class Rock extends OpenHand {
    @Override
    public HandResult againstRock() {
        return HandResult.Tie;
    }

    @Override
    public HandResult againstPaper() {
        return HandResult.Loose;
    }

    @Override
    public HandResult againstScissors() {
        return HandResult.Win;
    }

    @Override
    public Hand getCurrentHand(){
        return Hand.Rock;
    }
}
