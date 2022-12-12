package hartwig.interview.rps.input.adapters;

import hartwig.interview.rps.domain.rules.GoFactory;
import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.domain.rules.OpenHand;
import hartwig.interview.rps.domain.ports.Player;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Represents a computer player implementatio
 * Computer player implementation plays by generating random hands to be played
 */
@Component
public class ComputerPlayer implements Player {
    /**
     * @return OpenHand whcih represents a randomly played hand
     */
    @Override
    public OpenHand playHand() {
        int pick = new Random().nextInt(Hand.values().length);
        Hand hand = Hand.values()[pick];
        return GoFactory.openHand(hand).get();
    }
}
