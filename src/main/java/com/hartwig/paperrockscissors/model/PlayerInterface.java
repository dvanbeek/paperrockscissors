package com.hartwig.paperrockscissors.model;

/**
* Player interface
*
* Classes that implement PlayerInterface must provide a getMove method that returns a MoveEnum object
*/
public interface PlayerInterface {
  MoveEnum getMove();
}

