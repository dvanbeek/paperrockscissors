package com.hartwig.paperrockscissors.model;

import java.util.Random;

public class ComputerPlayer implements Player {
	private static final Random RANDOM_NUMBER_GENERATOR = new Random();

  /**
 	* Implements Player Interface: getMove() generates random move from the available options defined in Move.
 	*
  * @return Move
 	*/
  @Override
  public Move getMove() {
    // Retrieve number of Move options
    int numberOfMoveOptions = Move.getNumberOfMoveOptions();
    // Generate a number between 0 and numberOfMoveOptions-1
    int randomMoveNumber = RANDOM_NUMBER_GENERATOR.nextInt(numberOfMoveOptions);
    // Use Move.values() to generate an array of Move constants
    // and select the Move object from the enum for the random move number
    return Move.values()[randomMoveNumber];
  }
}