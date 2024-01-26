package com.hartwig.paperrockscissors.engine;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;
import com.hartwig.paperrockscissors.exceptions.QuitGameException;
import com.hartwig.paperrockscissors.model.MoveEnum;

/**
 * GameControls for human player
 * The method getPlayerMove parses keyboard input from human player 
 * Upon initializing GameControls the scanner should be injected 
 */
public class GameControls implements AutoCloseable {
  private final Scanner scanner;
  private static final String QUIT = "q";

  public GameControls (Scanner scanner) {
    this.scanner = Objects.requireNonNull(scanner, "Scanner can not be null");
  }

  /**
  * Reads the string entered into the keyboard 
  * @Return The move of a player, or throws an exception 
  * Note that the returned move is Optional thus can be null or of type enum Move
  * 
  * It can throw the following exceptions:
  * - QuitGameException: when the player has entered the Quit Command
  * - InvalidMoveException: when the player has entered an invalid Move
  */
  public MoveEnum getPlayerMove() {
    try {
      String input = scanner.next();
      if (input.equalsIgnoreCase(QUIT)) {
        throw new QuitGameException();
      }
      // Map input character to MoveEnum constant ('PAPER', etc)
      return MoveEnum.enumConstantFromCharacter(input);

    } catch (NoSuchElementException e) {
      // Catch the case where user presses ctrl-c or ctrl-z 
      // Assume user wants to quit in that case
      throw new QuitGameException();

    } catch (InvalidMoveException e) {
      // For clarity: catch any InvalidMoveException coming from MoveEnum.enumConstantFromCharacter(input)
      // and re-throw this for handling in game engine
      throw new InvalidMoveException();
    }
  }

  // Close the scanner on termination of GameControls
  @Override
  public void close() {
    scanner.close();
  }
}
