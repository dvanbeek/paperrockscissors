package nl.mplb.domain;

import org.junit.jupiter.api.Test;

import static nl.mplb.domain.Moves.PAPER;
import static nl.mplb.domain.Moves.ROCK;
import static nl.mplb.domain.Moves.SCISSORS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RefereeTest {
  public Referee referee = new Referee();

  @Test
  void testWinningCombinations() {
    assertEquals(
        GameOutcome.WIN,
        referee.determineGameOutcome(ROCK, SCISSORS),
        "Rock should win from scissors");
    assertEquals(
        GameOutcome.WIN, referee.determineGameOutcome(PAPER, ROCK), "Paper should win from rock");
    assertEquals(
        GameOutcome.WIN,
        referee.determineGameOutcome(SCISSORS, PAPER),
        "Scissors should win from paper");
  }

  @Test
  void testLosingCombinations() {
    assertEquals(
        GameOutcome.LOSE,
        referee.determineGameOutcome(SCISSORS, ROCK),
        "Scissors should lose from rock");
    assertEquals(
        GameOutcome.LOSE, referee.determineGameOutcome(ROCK, PAPER), "Rock should lose from paper");
    assertEquals(
        GameOutcome.LOSE,
        referee.determineGameOutcome(PAPER, SCISSORS),
        "Paper should lose from scissors");
  }

  @Test
  void testTieCombinations() {
    assertEquals(
        GameOutcome.TIE,
        referee.determineGameOutcome(ROCK, ROCK),
        "Rock and Rock should result in a Tie");
    assertEquals(
        GameOutcome.TIE,
        referee.determineGameOutcome(PAPER, PAPER),
        "Paper and Paper should result in a Tie");
    assertEquals(
        GameOutcome.TIE,
        referee.determineGameOutcome(SCISSORS, SCISSORS),
        "Scissors and Scissors should result in a Tie");
  }
}
