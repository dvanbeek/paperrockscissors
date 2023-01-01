package nl.mplb.domain;

import static nl.mplb.domain.GameOutcome.LOSE;
import static nl.mplb.domain.GameOutcome.TIE;
import static nl.mplb.domain.GameOutcome.WIN;

/** The logic to determine the outcome of two moves */
public class Referee {

  //             Rock     Paper    Scissors
  // Rock        T        L        W
  // Paper       W        T        L
  // Scissors    L        W        T
  private final GameOutcome[][] outcomeMatrix = {
    {TIE, LOSE, WIN},
    {WIN, TIE, LOSE},
    {LOSE, WIN, TIE}
  };

  /**
   * Determine the game outcome of two moves from the perspective of the first argument.
   *
   * @param m1 The move that was played by 'you'
   * @param m2 The move that was played by the 'other'
   * @return The game outcome
   */
  public GameOutcome determineGameOutcome(Moves m1, Moves m2) {
    return outcomeMatrix[m1.ordinal()][m2.ordinal()];
  }
}
