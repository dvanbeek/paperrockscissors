package nl.mplb.domain;

/** An interface implemented by all Players */
public interface IPlayer {
  public Moves getChosenMove();

  public void makeMove();
}
