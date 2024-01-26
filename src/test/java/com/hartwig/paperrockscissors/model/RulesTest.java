package com.hartwig.paperrockscissors.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    RoundResult result = Rules.evaluateMoves(Move.PAPER, Move.ROCK); 
    assertEquals(RoundResult.PLAYER1_WINS, result);

    result = Rules.evaluateMoves(Move.ROCK, Move.SCISSORS); 
    assertEquals(RoundResult.PLAYER1_WINS, result);

    result = Rules.evaluateMoves(Move.SCISSORS, Move.PAPER); 
    assertEquals(RoundResult.PLAYER1_WINS, result);
  }

  @Test
  @DisplayName("Player 2 wins")
  void testPlayer2Wins() {
    RoundResult result = Rules.evaluateMoves(Move.PAPER, Move.SCISSORS); 
    assertEquals(RoundResult.PLAYER2_WINS, result);

    result = Rules.evaluateMoves(Move.ROCK, Move.PAPER); 
    assertEquals(RoundResult.PLAYER2_WINS, result);

    result = Rules.evaluateMoves(Move.SCISSORS, Move.ROCK); 
    assertEquals(RoundResult.PLAYER2_WINS, result);
  }

  @Test
  @DisplayName("A tie")
  void testTie() {
    RoundResult result = Rules.evaluateMoves(Move.PAPER, Move.PAPER); 
    assertEquals(RoundResult.TIE, result);

    result = Rules.evaluateMoves(Move.ROCK, Move.ROCK); 
    assertEquals(RoundResult.TIE, result);

    result = Rules.evaluateMoves(Move.SCISSORS, Move.SCISSORS); 
    assertEquals(RoundResult.TIE, result);
  }
}
