package nl.mplb;

import nl.mplb.domain.Computer;
import nl.mplb.domain.Game;
import nl.mplb.domain.GameOutcome;
import nl.mplb.domain.Human;
import nl.mplb.domain.Referee;
import nl.mplb.domain.Score;
import nl.mplb.domain.UserInterface;

/** Initialises all other classes and is responsible for running multiple games. */
public class Main {

  public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    Score score = new Score();
    Referee referee = new Referee();

    userInterface.showWelcomeMessage();
    boolean userContinue = true;
    while (userContinue) {
      Human human = new Human(userInterface);
      Computer computer = new Computer();
      Game game = new Game(userInterface, human, computer, referee);

      GameOutcome gameOutcome = game.play();
      score.processNewOutcome(gameOutcome);
      userContinue = !userInterface.promptStopPlaying();
    }
    userInterface.showGameEndSummary(score.getWins(), score.getLoses(), score.getTies());
  }
}
