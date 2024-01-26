package com.hartwig.paperrockscissors.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hartwig.paperrockscissors.engine.RoundResultEnum;

/**
  * Test the rules handling by injecting the player 1 and player 2 moves that should result in:
  * - Player 1 wins
  * - Player 2 wins
  * - A tie
 */
class RulesTest {
  @Test
  @DisplayName("Player 1 wins")
  void testPlayer1Wins() {
    RoundResultEnum result = Rules.evaluateMoves(MoveEnum.PAPER, MoveEnum.ROCK); 
    assertEquals(RoundResultEnum.PLAYER1_WINS, result);

    result = Rules.evaluateMoves(MoveEnum.ROCK, MoveEnum.SCISSORS); 
    assertEquals(RoundResultEnum.PLAYER1_WINS, result);

    result = Rules.evaluateMoves(MoveEnum.SCISSORS, MoveEnum.PAPER); 
    assertEquals(RoundResultEnum.PLAYER1_WINS, result);
  }

  @Test
  @DisplayName("Player 2 wins")
  void testPlayer2Wins() {
    RoundResultEnum result = Rules.evaluateMoves(MoveEnum.PAPER, MoveEnum.SCISSORS); 
    assertEquals(RoundResultEnum.PLAYER2_WINS, result);

    result = Rules.evaluateMoves(MoveEnum.ROCK, MoveEnum.PAPER); 
    assertEquals(RoundResultEnum.PLAYER2_WINS, result);

    result = Rules.evaluateMoves(MoveEnum.SCISSORS, MoveEnum.ROCK); 
    assertEquals(RoundResultEnum.PLAYER2_WINS, result);
  }

  @Test
  @DisplayName("A tie")
  void testTie() {
    RoundResultEnum result = Rules.evaluateMoves(MoveEnum.PAPER, MoveEnum.PAPER); 
    assertEquals(RoundResultEnum.TIE, result);

    result = Rules.evaluateMoves(MoveEnum.ROCK, MoveEnum.ROCK); 
    assertEquals(RoundResultEnum.TIE, result);

    result = Rules.evaluateMoves(MoveEnum.SCISSORS, MoveEnum.SCISSORS); 
    assertEquals(RoundResultEnum.TIE, result);
  }
}
