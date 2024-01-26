package com.hartwig.paperrockscissors.model;

import java.util.EnumMap;
import java.util.Map;

import com.hartwig.paperrockscissors.engine.RoundResultEnum;
import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;

/**
* ... 
*
*/
public class Rules {
  
  private Rules() {
    // This constructor is private to prevent instantiation of this Rules utility class.
  }

  /**
  * EnumMap with rules for winning combinations
  * Defines which Player 1 Move (key) beats which Player 2 Move (value)
  */
  private static final Map<MoveEnum, MoveEnum> gameRules = new EnumMap<>(MoveEnum.class);

  static {
    gameRules.put(MoveEnum.PAPER, MoveEnum.ROCK);
    gameRules.put(MoveEnum.ROCK, MoveEnum.SCISSORS);
    gameRules.put(MoveEnum.SCISSORS, MoveEnum.PAPER);
  }

  /**
  * Static method to evaluate moves and determine the winner using the gameRules Map
  * @param player1Move the move of player 1.
  * @param player2Move the move of player 2.
  * @return RoundResultEnum
  */
  public static final RoundResultEnum evaluateMoves(MoveEnum player1Move, MoveEnum player2Move) {
    // Safety check to make sure player1Move is a valid move, if not throw InvalidMoveException
    if (gameRules.get(player1Move) == null) {
      throw new InvalidMoveException();
    }
    
    // Determine who has won
    if (player1Move.equals(player2Move)) {
      return RoundResultEnum.TIE;
    } else if (gameRules.get(player1Move).equals(player2Move))  {
      return RoundResultEnum.PLAYER1_WINS;
    } else {
      return RoundResultEnum.PLAYER2_WINS;
    }
  }
}
