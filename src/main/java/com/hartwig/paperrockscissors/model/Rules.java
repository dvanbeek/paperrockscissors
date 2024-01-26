package com.hartwig.paperrockscissors.model;

import java.util.EnumMap;
import java.util.Map;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;

/**
* Contains a Map of rules (what beats what) and a static method to return the result based on the moves of 2 players
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
  private static final Map<Move, Move> gameRules = new EnumMap<>(Move.class);

  static {
    gameRules.put(Move.PAPER, Move.ROCK);
    gameRules.put(Move.ROCK, Move.SCISSORS);
    gameRules.put(Move.SCISSORS, Move.PAPER);
  }

  /**
  * Static method to evaluate moves and determine the winner using the gameRules Map
  * @param player1Move the move of player 1.
  * @param player2Move the move of player 2.
  * @return RoundResult
  */
  public static final RoundResult evaluateMoves(Move player1Move, Move player2Move) {
    // Safety check to make sure player1Move is a valid move, if not throw InvalidMoveException
    if (gameRules.get(player1Move) == null) {
      throw new InvalidMoveException();
    }
    
    // Determine who has won
    if (player1Move.equals(player2Move)) {
      return RoundResult.TIE;
    } else if (gameRules.get(player1Move).equals(player2Move))  {
      return RoundResult.PLAYER1_WINS;
    } else {
      return RoundResult.PLAYER2_WINS;
    }
  }
}
