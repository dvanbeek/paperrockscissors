package nl.mplb.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to keep track of the score New game outcomes are added to the outcomes array. To
 * determine the score the number of occurrences of each outcome is counted.
 */
public class Score {
  private final List<GameOutcome> outcomes = new ArrayList<>();

  public void processNewOutcome(GameOutcome outcome) {
    this.outcomes.add(outcome);
  }

  public long getWins() {
    return countNumberOf(GameOutcome.WIN);
  }

  public long getLoses() {
    return countNumberOf(GameOutcome.LOSE);
  }

  public long getTies() {
    return countNumberOf(GameOutcome.TIE);
  }

  private long countNumberOf(GameOutcome outcome) {
    return outcomes.stream().filter(o -> o == outcome).count();
  }
}
