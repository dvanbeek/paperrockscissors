package nl.mplb.domain;

import nl.mplb.exceptions.InvalidMoveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovesTest {
  @Test
  void testFromStringRock() {
    assertEquals(Moves.ROCK, Moves.fromString("R"));
    assertEquals(Moves.ROCK, Moves.fromString("Rock"));
    assertEquals(Moves.ROCK, Moves.fromString("r"));
    assertEquals(Moves.ROCK, Moves.fromString("rock"));
    assertEquals(Moves.ROCK, Moves.fromString("rOck"));
  }

  @Test
  void testFromStringPaper() {
    assertEquals(Moves.PAPER, Moves.fromString("P"));
    assertEquals(Moves.PAPER, Moves.fromString("Paper"));
    assertEquals(Moves.PAPER, Moves.fromString("p"));
    assertEquals(Moves.PAPER, Moves.fromString("paper"));
    assertEquals(Moves.PAPER, Moves.fromString("pApEr"));
  }

  @Test
  void testFromStringScissors() {
    assertEquals(Moves.SCISSORS, Moves.fromString("S"));
    assertEquals(Moves.SCISSORS, Moves.fromString("Scissors"));
    assertEquals(Moves.SCISSORS, Moves.fromString("s"));
    assertEquals(Moves.SCISSORS, Moves.fromString("scissors"));
    assertEquals(Moves.SCISSORS, Moves.fromString("sCisSorS"));
  }

  @Test
  void testInvalidMoveExceptionFromStringWithNullInput() {
    assertThrows(InvalidMoveException.class, () -> Moves.fromString(null));
  }

  @Test
  void testInvalidMoveExceptionFromStringWithInvalidInput() {
    assertThrows(InvalidMoveException.class, () -> Moves.fromString("SomethingInvalid"));
  }
}
