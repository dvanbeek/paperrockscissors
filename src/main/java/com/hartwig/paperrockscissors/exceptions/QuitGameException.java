package com.hartwig.paperrockscissors.exceptions;

/**
* ... 
*
*/
public class QuitGameException extends RuntimeException {
  public QuitGameException() {
      super("Request to quit the game.");
  }
}