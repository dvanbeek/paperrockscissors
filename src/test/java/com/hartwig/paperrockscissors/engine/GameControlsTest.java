package com.hartwig.paperrockscissors.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;
import com.hartwig.paperrockscissors.exceptions.QuitGameException;
import com.hartwig.paperrockscissors.model.Move;

/**
  * Test the GameControls for the following:
  * - Handling a valid move.
  * - Receiving InvalidMoveException upon invalid move of one character.
  * - Receiving InvalidMoveException upon entry of more than one character.
  * - Receiving QuitGameException upon receiving the quit command.
 */
class GameControlsTest {
  private ByteArrayOutputStream outContent;
  private PrintStream originalOut;
  private GameControls gameControls;
  private Scanner scanner;

  // Test values
  private final String INPUT_PAPER = "p";
  private final String INPUT_INVALID = "i";
  private final String INPUT_INVALID2 = "invalid";
  private final String INPUT_QUIT = "q";

  @BeforeEach
  // Initialize output stream
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outContent));
  }

  // Utility function to set entered game input 
  private void initializeGameControlsWithInput(String input) {
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    scanner = new Scanner(in);
    gameControls = new GameControls(scanner);
  }

  @AfterEach
  public void tearDown() {
    System.setOut(originalOut);
    if (scanner != null) {
      scanner.close();
    }
    if (gameControls != null) {
      gameControls.close();
    }
  }

  @Test
  @DisplayName("Should correctly process valid move")
  void testValidInput() {
    initializeGameControlsWithInput(INPUT_PAPER);
    Move result = gameControls.getPlayerMove();
    assertEquals(Move.PAPER, result);
  }

  @Test
  @DisplayName("Should throw InvalidMoveException for invalid move of one character")
  void testInvalidInput() {
    initializeGameControlsWithInput(INPUT_INVALID);
    assertThrows(InvalidMoveException.class, () -> gameControls.getPlayerMove());
  }

  @Test
  @DisplayName("Should throw InvalidMoveException for invalid move of more than one character")
  void testInvalidInput2() {
    initializeGameControlsWithInput(INPUT_INVALID2);
    assertThrows(InvalidMoveException.class, () -> gameControls.getPlayerMove());
  }

  @Test
  @DisplayName("Should throw QuitGameException upon receiving quit command")
  void testQuit() {
    initializeGameControlsWithInput(INPUT_QUIT);
    assertThrows(QuitGameException.class, () -> gameControls.getPlayerMove());
  }
}
