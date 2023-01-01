package nl.mplb.domain;

/** The Game class is responsible for running a single game */
public class Game {
  UserInterface userInterface;
  IPlayer human;
  IPlayer computer;
  Referee referee;

  public Game(UserInterface userInterface, IPlayer human, IPlayer computer, Referee referee) {
    this.userInterface = userInterface;
    this.human = human;
    this.computer = computer;
    this.referee = referee;
  }

  /**
   * Runs through the steps to perform a single Game
   *
   * @return The outcome of a game
   */
  public GameOutcome play() {
    userInterface.buildExcitementBeforeGame();
    makeMoves();
    GameOutcome gameOutcome = determineGameOutcome();
    userInterface.showGameResults(
        this.human.getChosenMove(), this.computer.getChosenMove(), gameOutcome);
    return gameOutcome;
  }

  private void makeMoves() {
    this.human.makeMove();
    this.computer.makeMove();
  }

  private GameOutcome determineGameOutcome() {
    Moves humanMove = this.human.getChosenMove();
    Moves computerMove = this.computer.getChosenMove();
    return this.referee.determineGameOutcome(humanMove, computerMove);
  }
}
