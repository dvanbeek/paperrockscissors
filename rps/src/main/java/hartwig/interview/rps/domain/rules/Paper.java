package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.data.HandResult;
import org.springframework.stereotype.Component;

/**
 * Represents a paper implementation of hand played
 */
@Component
class Paper extends OpenHand {
    @Override
    public HandResult againstRock() {
        return HandResult.Win;
    }

    @Override
    public HandResult againstPaper() {
        return HandResult.Tie;
    }

    @Override
    public HandResult againstScissors() {
        return HandResult.Loose;
    }

    public Hand getCurrentHand(){
        return Hand.Paper;
    }
}
