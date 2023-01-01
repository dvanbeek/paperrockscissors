package nl.mplb.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HumanTest {
  @Mock UserInterface userInterface;
  Human human;

  @BeforeEach
  void setUp() {
    human = new Human(userInterface);
  }

  @Test
  void testMakeMoveHappyPath() {
    when(userInterface.promptMove()).thenReturn("P");
    human.makeMove();
    assertEquals(Moves.PAPER, human.getChosenMove());
    Mockito.verify(userInterface, times(1)).promptMove();
  }

  @Test
  void testMakeMoveInvalidInput() {
    when(userInterface.promptMove()).thenReturn("Invalid", "Something", "Rock", "Paper");
    human.makeMove();
    assertEquals(Moves.ROCK, human.getChosenMove());
    Mockito.verify(userInterface, times(3)).promptMove();
    Mockito.verify(userInterface, times(2)).showAvailableMoves();
  }
}
