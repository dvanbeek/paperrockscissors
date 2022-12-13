package hartwig.interview.rps.domain.scores.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerScoreTest {

    @Test
    void recordWin_NoExistingWins_Returns1() {
        PlayerScore score = new PlayerScore(0,0,0);
        score.recordWin();
        assertEquals(score.getWins(), 1);
    }

    @Test
    void recordWin_1ExistingWin_Returns2() {
        PlayerScore score = new PlayerScore(1,0,0);
        score.recordWin();
        assertEquals(score.getWins(), 2);
    }

    @Test
    void recordLoss_2ExistingLosses_Returns2() {
        PlayerScore score = new PlayerScore(1,2,0);
        score.recordLoss();
        assertEquals(score.getLosses(), 3);
    }

    @Test
    void recordLoss_NoExistingLosses_Returns1() {
        PlayerScore score = new PlayerScore(1,0,0);
        score.recordLoss();
        assertEquals(score.getLosses(), 1);
    }

    @Test
    void recordTie_2ExistingTies_Returns4() {
        PlayerScore score = new PlayerScore(1,2,2);
        score.recordTie();
        assertEquals(score.getTies(), 3);
    }

    @Test
    void recordLoss_NoExistingTies_Returns1() {
        PlayerScore score = new PlayerScore(1,0,0);
        score.recordTie();
        assertEquals(score.getTies(), 1);
    }
}