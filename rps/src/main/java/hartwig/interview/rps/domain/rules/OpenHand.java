package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.data.HandResult;

/**
 * Represents the hand played and rules specification to which more concrete implementation should adhere to
 */
public abstract class OpenHand {
    /**
     * @return HandResult when played against a rock
     */
    public abstract HandResult againstRock();

    /**
     * @return HandResult when played against a paper
     */
    public abstract HandResult againstPaper();

    /**
     * @return HandResult when played against scissors
     */
    public abstract HandResult againstScissors();

    /**
     * @return Hand value of the current hand
     */
    public abstract Hand getCurrentHand();
}
