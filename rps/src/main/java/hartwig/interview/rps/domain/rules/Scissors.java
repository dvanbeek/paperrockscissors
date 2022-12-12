package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.data.HandResult;
import org.springframework.stereotype.Component;

/**
 * Represents scissors implementation of hand played
 */
@Component
class Scissors extends OpenHand {
    @Override
    public HandResult againstRock() {
        return HandResult.Loose;
    }

    @Override
    public HandResult againstPaper() {
        return HandResult.Win;
    }

    @Override
    public HandResult againstScissors() {
        return HandResult.Tie;
    }
    @Override
    public Hand getCurrentHand(){
        return Hand.Scissors;
    }

}
