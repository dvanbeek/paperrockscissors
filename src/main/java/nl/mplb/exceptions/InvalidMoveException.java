package nl.mplb.exceptions;

/** Thrown when an invalid move is made */
public class InvalidMoveException extends RuntimeException {
  public InvalidMoveException(String message) {
    super(message);
  }
}
