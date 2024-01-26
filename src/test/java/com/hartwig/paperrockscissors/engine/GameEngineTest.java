package com.hartwig.paperrockscissors.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hartwig.paperrockscissors.exceptions.QuitGameException;
import com.hartwig.paperrockscissors.model.MoveEnum;
import com.hartwig.paperrockscissors.model.PlayerInterface;

/**
  * Test the GameEngine for the following:
  * - Player 1 Wins.
  * - Player 2 Wins
  * - A tie.
 */
class GameEngineTest {
  private ByteArrayOutputStream outContent;
  private PrintStream originalOut;

  // Test values

  @BeforeEach
  // Initialize output stream
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("Player 1 wins")
  void testPlayer1Wins() {
    PlayerInterface player1 = mock(PlayerInterface.class);
    PlayerInterface player2 = mock(PlayerInterface.class);
    // Given
    when(player1.getMove()).thenReturn(MoveEnum.PAPER);
    when(player2.getMove()).thenReturn(MoveEnum.ROCK).thenThrow(new QuitGameException());;
    GameEngine game = new GameEngine(player1, player2);
    // When
    try {
      game.start();
    } catch (QuitGameException e) {
      // Expected exception to exit the game loop
    }
    // Then
    assertTrue(outContent.toString().contains("You win!"));  
    assertTrue(outContent.toString().contains("In this session you have played 1 times."));  
    assertTrue(outContent.toString().contains("You won 1 times."));
    assertTrue(outContent.toString().contains("You lost 0 times."));
    assertTrue(outContent.toString().contains("There were 0 ties."));
  }

  @Test
  @DisplayName("Player 2 wins")
  void testPlayer2Wins() {
    PlayerInterface player1 = mock(PlayerInterface.class);
    PlayerInterface player2 = mock(PlayerInterface.class);
    // Given
    when(player1.getMove()).thenReturn(MoveEnum.ROCK);
    when(player2.getMove()).thenReturn(MoveEnum.PAPER).thenThrow(new QuitGameException());;
    GameEngine game = new GameEngine(player1, player2);
    // When
    try {
      game.start();
    } catch (QuitGameException e) {
      // Expected exception to exit the game loop
    }
    // Then
    assertTrue(outContent.toString().contains("You lose!"));  
    assertTrue(outContent.toString().contains("In this session you have played 1 times."));  
    assertTrue(outContent.toString().contains("You won 0 times."));
    assertTrue(outContent.toString().contains("You lost 1 times."));
    assertTrue(outContent.toString().contains("There were 0 ties."));
  }

  @Test
  @DisplayName("Test tie")
  void testTie() {
    PlayerInterface player1 = mock(PlayerInterface.class);
    PlayerInterface player2 = mock(PlayerInterface.class);
    // Given
    when(player1.getMove()).thenReturn(MoveEnum.PAPER);
    when(player2.getMove()).thenReturn(MoveEnum.PAPER).thenThrow(new QuitGameException());;
    GameEngine game = new GameEngine(player1, player2);
    // When
    try {
      game.start();
    } catch (QuitGameException e) {
      // Expected exception to exit the game loop
    }
    // Then
    assertTrue(outContent.toString().contains("It's a tie!"));  
    assertTrue(outContent.toString().contains("In this session you have played 1 times."));  
    assertTrue(outContent.toString().contains("You won 0 times."));
    assertTrue(outContent.toString().contains("You lost 0 times."));
    assertTrue(outContent.toString().contains("There were 1 ties."));
  }
}
