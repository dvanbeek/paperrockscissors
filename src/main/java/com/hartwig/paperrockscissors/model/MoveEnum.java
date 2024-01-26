package com.hartwig.paperrockscissors.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;

/**
* ... 
*
*/
public enum MoveEnum {
  PAPER("p"),
  ROCK("r"),
  SCISSORS("s");

  private final String value;
  // Static unmodifiable map of string representations to corresponding MoveEnum constants.
  // For example the first entry in this map will be Key: "p", Value: MoveEnum.PAPER 
  private static final Map<String, MoveEnum> STRING_TO_ENUM_CONSTANT_MAP
      = Collections.unmodifiableMap(initializeMap());

  // Constructor
  MoveEnum(String value) {
    this.value = value;
  }
  
  // get character value
	public String getValue() {
    return value;
	}

  private static Map<String, MoveEnum> initializeMap() {
    Map<String, MoveEnum> map = new HashMap<>();
    for (MoveEnum move : MoveEnum.values()) {
      map.put(move.value, move);
    }
    return map;
  }

  // Converts input string to lowercase and looks up input in Map of MoveEnum constants
  // Returns MoveEnum constant, for example MoveEnum.PAPER for moveString 'p'
  // Throws InvalidMoveException if moveString cannot be found in STRING_TO_ENUM_CONSTANT_MAP
  public static MoveEnum enumConstantFromCharacter(String moveString) {
    MoveEnum move = STRING_TO_ENUM_CONSTANT_MAP.get(moveString.toLowerCase());
    if (move == null) {
      throw new InvalidMoveException();
    }
    return move;
  }

  public static int getNumberOfMoveOptions() {
      return MoveEnum.values().length;
  }

}
