package com.hartwig.paperrockscissors.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hartwig.paperrockscissors.engine.GameControls;

/**
  * Test the HumanPlayer for the following:
  * - That the HumanPlayer class correctly delegates the move choice to the GameControls.
 */
class HumanPlayerTest {
  private PlayerInterface humanPlayer;
  private GameControls gameControls;

  @BeforeEach
  public void setUp() {
    gameControls = Mockito.mock(GameControls.class);
    humanPlayer = new HumanPlayer(gameControls);
  }

  @Test
  @DisplayName("Should correctly delegate the move choice to the GameControls")
  void testDelegatesToInputHandler() {
    when(gameControls.getPlayerMove()).thenReturn(MoveEnum.ROCK); 
    MoveEnum move = humanPlayer.getMove();
    verify(gameControls, times(1)).getPlayerMove(); 
    assertEquals(MoveEnum.ROCK, move);
  }
}
