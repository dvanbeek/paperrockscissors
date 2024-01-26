package com.hartwig.paperrockscissors.exceptions;

/**
* ... 
*
*/
public class InvalidMoveException extends IllegalArgumentException {
  public InvalidMoveException() {
      super("Invalid Move!");
  }
}
