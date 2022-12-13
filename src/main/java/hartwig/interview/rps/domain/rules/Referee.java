package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.data.HandResult;
import org.springframework.stereotype.Component;

/**
 * Represents a referee object which decides on the result of the hand played
 */
@Component
 public class Referee {

    /**
     * @param playerMove player move for the player at stake
     * @param opponentMove player move for the opponent of the player
     * @return HandResult which specifies whether the player has won or lost
     */
    public HandResult judge(OpenHand playerMove, OpenHand opponentMove) {
        var handPlayed = opponentMove.getCurrentHand();
        if(handPlayed == Hand.Rock)
            return playerMove.againstRock();
        else if(handPlayed == Hand.Paper)
            return playerMove.againstPaper();
        else if (handPlayed == Hand.Scissors)
            return playerMove.againstScissors();
        return HandResult.None;
    }
}
