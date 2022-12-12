package hartwig.interview.rps.domain;

import hartwig.interview.rps.domain.ports.Player;
import org.springframework.stereotype.Component;

/**
 * Game factory is encapsulating logic for creating a specific game instance for two playes
 */
public class RPSFactory {
    public static RPSGame initializeGame(Player player1, Player player2) {
        return new RPSGame(player1, player2);
    }
}
