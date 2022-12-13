package hartwig.interview.rps.domain.ports;

import hartwig.interview.rps.domain.rules.OpenHand;

import java.util.Optional;

/**
 * This interface specifies the behavior of a player.
 */
public interface Player {
    /**
     * Reveals a player hand
     *
     * @return OpenHand {Rock, Paper, Scissors}
     */
    Optional<OpenHand> playHand();
}
