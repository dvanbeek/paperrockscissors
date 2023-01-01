package nl.mplb.domain;

import nl.mplb.exceptions.InvalidMoveException;

/**
 * Enum with the possible moves. Has methods to convert to and from a String, for input and display
 * purposes.
 */
public enum Moves {
  ROCK("Rock"),
  PAPER("Paper"),
  SCISSORS("Scissors");

  private final String display;

  Moves(String display) {
    this.display = display;
  }

  public static Moves fromString(String input) {
    if (input == null || input.isBlank()) {
      throw new InvalidMoveException("Move can't be empty");
    }

    String normalizedInput = input.toLowerCase().strip();
    switch (normalizedInput) {
      case "r":
      case "rock":
        return ROCK;
      case "p":
      case "paper":
        return PAPER;
      case "s":
      case "scissors":
        return SCISSORS;
      default:
        throw new InvalidMoveException("Unknown move");
    }
  }

  @Override
  public String toString() {
    return this.display;
  }
}
