package hartwig.interview.rps.domain;

import hartwig.interview.rps.domain.ports.Game;
import hartwig.interview.rps.domain.ports.Player;
import hartwig.interview.rps.domain.rules.Referee;
import hartwig.interview.rps.domain.scores.data.GameStatus;
import hartwig.interview.rps.domain.scores.model.GameScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

;

/**
 * Represents the rock-paper-scissors game object
 */
class RPSGame implements Game {

    /**
     * represents player1
     */
    private Player player1;


    /**
     * represents player2
     */
    private Player player2;

    /**
     * represents the game score
     */
    private GameScore gameScore;

    /**
     * represents the current game status
     */
    private GameStatus status;

    /**
     * represents the game referee
     */
    @Autowired
    private Referee referee;

    /**
     * This method is responsible for starting the game.
     * It initializes all objects necessary for the game to be played.
     * @param player1
     * @param player2
     */
    @Autowired
    public RPSGame(Player player1, Player player2) {
        gameScore = new GameScore(player1.toString(), player2.toString());
        referee = new Referee();
        status = GameStatus.ACTIVE;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * This method allows a round to be played, by letting the players take their turns and
     * employing the referee to decide on the outcome.
     */
    @Override
    public void playRound() {
        var player1Hand = player1.playHand();
        var player2Hand = player2.playHand();
        System.out.println("You played :" + player1Hand.getCurrentHand().name());
        System.out.println("Opponent played :" + player2Hand.getCurrentHand().name());
        var roundResult = referee.judge(player1Hand, player2Hand);
        gameScore.recordScore(roundResult, player1.toString(), player2.toString());
    }

    /**
     * This methods provides the game result and ends the game.
     * @return GameScore which contains the full game score
     */
    @Override
    public GameScore endGameResult() {
        status = GameStatus.DONE;
        return this.gameScore;
    }
}
