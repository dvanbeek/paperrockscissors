package nl.mplb.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {

  @Test
  void testScoreIsCalculatedCorrectly() {
    Score score = new Score();
    score.processNewOutcome(GameOutcome.WIN);
    score.processNewOutcome(GameOutcome.WIN);
    score.processNewOutcome(GameOutcome.LOSE);
    score.processNewOutcome(GameOutcome.TIE);
    assertEquals(2, score.getWins());
    assertEquals(1, score.getLoses());
    assertEquals(1, score.getTies());
  }
}
