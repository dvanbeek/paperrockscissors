package nl.mplb.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class GameTest {
  @Mock UserInterface userInterface;
  @Mock IPlayer human;
  @Mock IPlayer computer;
  @Mock Referee referee;

  @InjectMocks Game game = new Game(userInterface, human, computer, referee);

  @Test
  void testExpectedCallsAreMadeWhenPlayingTheGame() {
    game.play();
    Mockito.verify(userInterface, times(1)).buildExcitementBeforeGame();
    Mockito.verify(human, times(1)).makeMove();
    Mockito.verify(computer, times(1)).makeMove();
    Mockito.verify(referee, times(1)).determineGameOutcome(any(), any());
    Mockito.verify(userInterface, times(1)).showGameResults(any(), any(), any());
  }
}
