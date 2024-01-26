package com.hartwig.paperrockscissors.model;

import java.util.Random;

public class ComputerPlayer implements PlayerInterface {
	private static final Random RANDOM_NUMBER_GENERATOR = new Random();

  /**
 	* Generates random computer move from the available options defined in MoveEnum
 	*
  * @return MoveEnum
 	*/
  @Override
  public MoveEnum getMove() {
    // Retrieve number of MoveEnum options
    int numberOfMoveOptions = MoveEnum.getNumberOfMoveOptions();
    // Generate a number between 0 and numberOfMoveOptions-1
    int randomMoveNumber = RANDOM_NUMBER_GENERATOR.nextInt(numberOfMoveOptions);
    // Use MoveEnum.values() to generate an array of MoveEnum constants
    // and select the MoveEnum object from the enum for the random move number
    return MoveEnum.values()[randomMoveNumber];
  }
}