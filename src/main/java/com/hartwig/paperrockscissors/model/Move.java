package com.hartwig.paperrockscissors.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;

/**
* Enumerates the possible moves (currently PAPER, ROCK, SCISSORS, but extendible) 
* Defines private static unmodifiable map of string representations to corresponding Move constants.
* Provides method enumConstantFromCharacter that converts input string to lowercase and looks up input in Map of Move constants
* Provides method getNumberOfMoveOptions that returns the total number of possible moves.
*
*/
public enum Move {
  PAPER("p"),
  ROCK("r"),
  SCISSORS("s");

  private final String value;
  // Static unmodifiable map of string representations to corresponding Move constants.
  // For example the first entry in this map will be Key: "p", Value: Move.PAPER 
  private static final Map<String, Move> STRING_TO_ENUM_CONSTANT_MAP
      = Collections.unmodifiableMap(initializeMap());

  // Constructor
  Move(String value) {
    this.value = value;
  }

  private static Map<String, Move> initializeMap() {
    Map<String, Move> map = new HashMap<>();
    for (Move move : Move.values()) {
      map.put(move.value, move);
    }
    return map;
  }

  // Converts input string to lowercase and looks up input in Map of Move constants
  // Returns Move constant, for example Move.PAPER for moveString 'p'
  // Throws InvalidMoveException if moveString cannot be found in STRING_TO_ENUM_CONSTANT_MAP
  public static Move enumConstantFromCharacter(String moveString) {
    Move move = STRING_TO_ENUM_CONSTANT_MAP.get(moveString.toLowerCase());
    if (move == null) {
      throw new InvalidMoveException();
    }
    return move;
  }

  public static int getNumberOfMoveOptions() {
      return Move.values().length;
  }

}
