package hartwig.interview.rps.domain.ports;

import hartwig.interview.rps.domain.RPSFactory;
import hartwig.interview.rps.domain.scores.model.GameScore;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Delagate class providing access to game functions without exposing the object itself
 * Knows nothing about the specific game implementation
 */
@Component
@NoArgsConstructor
public class GameManager {
    Game game;

    public GameManager(Player player1, Player player2){
        game = RPSFactory.initializeGame(player1, player2);
    }
    public void playRound(){
        game.playRound();
    }
    public GameScore endGame() {
        return game.endGameResult();
    }
}
