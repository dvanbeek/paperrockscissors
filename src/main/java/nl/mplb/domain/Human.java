package nl.mplb.domain;

import nl.mplb.exceptions.InvalidMoveException;

/** The Human player. A player where the chosen move is set by the user. */
public class Human implements IPlayer {
  private final UserInterface userInterface;
  private Moves chosenMove;

  public Human(UserInterface userInterface) {
    this.userInterface = userInterface;
  }

  public Moves getChosenMove() {
    return this.chosenMove;
  }

  public void makeMove() {
    // While no (known) move is chosen, keep asking
    while (this.chosenMove == null) {
      try {
        String input = this.userInterface.promptMove();
        this.chosenMove = Moves.fromString(input);
      } catch (InvalidMoveException e) {
        this.userInterface.showAvailableMoves();
      }
    }
  }
}
