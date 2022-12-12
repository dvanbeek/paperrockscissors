package hartwig.interview.rps.domain.scores.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a player specific score for the game
 */
@Getter
@AllArgsConstructor
public class PlayerScore {

    /**
     * no. of current wins for the player
     */
    private int wins;
    /**
     * no. of current losses for the player
     */
    private int losses;
    /**
     * no. of current ties for the player
     */
    private int ties;

    /**
     * Record a win for a player
     */
    public void recordWin(){
        this.wins++;
    }

    /**
     * Records a loss for the player
     */
    public void recordLoss(){
        this.losses++;
    }

    /**
     * Recors a tie for the player
     */
    public void recordTie(){
        this.ties++;
    }
}
