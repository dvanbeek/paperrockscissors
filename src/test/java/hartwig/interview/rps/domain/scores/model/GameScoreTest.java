package hartwig.interview.rps.domain.scores.model;

import hartwig.interview.rps.domain.rules.data.HandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameScoreTest {

    @Test
    public void recordScore_RecordP1Win_Returns_1P1Win_1P2Loss(){
        GameScore gameScore = new GameScore("P1", "P2");
        HandResult handResult = HandResult.Win;
        gameScore.recordScore(handResult, "P1", "P2");
        assertEquals(gameScore.getPlayerScore().get("P1").getWins(), 1);
        assertEquals(gameScore.getPlayerScore().get("P1").getLosses(), 0);
        assertEquals(gameScore.getPlayerScore().get("P1").getTies(), 0);

        assertEquals(gameScore.getPlayerScore().get("P2").getWins(), 0);
        assertEquals(gameScore.getPlayerScore().get("P2").getLosses(), 1);
        assertEquals(gameScore.getPlayerScore().get("P2").getTies(), 0);
    }

    @Test
    public void recordScore_RecordP1Loss_Returns_1P1Loss_1P2Win(){
        GameScore gameScore = new GameScore("P1", "P2");
        HandResult handResult = HandResult.Loose;
        gameScore.recordScore(handResult, "P1", "P2");
        assertEquals(gameScore.getPlayerScore().get("P1").getWins(), 0);
        assertEquals(gameScore.getPlayerScore().get("P1").getLosses(), 1);
        assertEquals(gameScore.getPlayerScore().get("P1").getTies(), 0);

        assertEquals(gameScore.getPlayerScore().get("P2").getWins(), 1);
        assertEquals(gameScore.getPlayerScore().get("P2").getLosses(), 0);
        assertEquals(gameScore.getPlayerScore().get("P2").getTies(), 0);
    }

    @Test
    public void recordScore_RecordTie_Returns_1P1Tie_1P2Tie(){
        GameScore gameScore = new GameScore("P1", "P2");
        HandResult handResult = HandResult.Tie;
        gameScore.recordScore(handResult, "P1", "P2");
        assertEquals(gameScore.getPlayerScore().get("P1").getWins(), 0);
        assertEquals(gameScore.getPlayerScore().get("P1").getLosses(), 0);
        assertEquals(gameScore.getPlayerScore().get("P1").getTies(), 1);

        assertEquals(gameScore.getPlayerScore().get("P2").getWins(), 0);
        assertEquals(gameScore.getPlayerScore().get("P2").getLosses(), 0);
        assertEquals(gameScore.getPlayerScore().get("P2").getTies(), 1);
    }
}