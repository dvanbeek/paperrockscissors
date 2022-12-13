package hartwig.interview.rps.input.adapters;

import hartwig.interview.rps.domain.ports.Player;
import hartwig.interview.rps.domain.rules.GoFactory;
import hartwig.interview.rps.domain.rules.OpenHand;
import hartwig.interview.rps.input.HandDomainMapper;
import hartwig.interview.rps.input.data.InputHand;
import hartwig.interview.rps.input.interfaces.Reader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Represents an input dependant player
 * This player requires a human invoked input in order to continue
 * Input type is left open to more concrete implementations
 */
public abstract class InputDependantPlayer implements Player {
    protected Reader reader;

    @Autowired
    public InputDependantPlayer(Reader reader){
        this.reader = reader;
    }

    /**
     * @return OpenHand which is specifies by a user
     */
    @Override
    public final Optional<OpenHand> playHand() {
        System.out.println("Your turn:");
        var handPlayed = reader.resolve(getPlayerInput());
        if(handPlayed == InputHand.PlayAgain)
            return Optional.empty();
        var hand = HandDomainMapper.mapHandToDomain(handPlayed);
        return GoFactory.openHand(hand.get());
    }

    /**
     * @return User provided input
     */
    protected abstract String getPlayerInput();
}
