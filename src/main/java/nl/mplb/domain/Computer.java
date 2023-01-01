package nl.mplb.domain;

import java.util.Random;

/** The Computer player. A player where the chosen move is set by the computer. */
public class Computer implements IPlayer {
  private final Random random = new Random();
  private Moves chosenMove;

  @Override
  public Moves getChosenMove() {
    return this.chosenMove;
  }

  @Override
  public void makeMove() {
    int nrMoves = Moves.values().length;
    int chosen = random.nextInt(nrMoves);
    this.chosenMove = Moves.values()[chosen];
  }
}
