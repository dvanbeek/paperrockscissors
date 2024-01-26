package com.hartwig.paperrockscissors.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
  * Test the ComputerPlayer for the following:
  * - Move is not null: Ensure that the method does not returns a null move.
  * - Move is within valid range: Ensure that the method always returns a valid move.
  * - Randomness over multiple calls: Over a large number of calls, ensure that all moves are selected to ensure randomness.
 */
class ComputerPlayerTest {
  private final Player computerPlayer = new ComputerPlayer();
  private final int NUM_TRIALS = 10000;

  @Test
  @DisplayName("Move is not null")
  void testMoveIsNotNull() {
    Move move = computerPlayer.getMove();
    assertNotNull(move);
  }

  @Test
  @DisplayName("Move is within valid range")
  void testMoveIsWithinValidRange() {
    for (int i = 0; i < NUM_TRIALS; i++) {
      Move move = computerPlayer.getMove();
      assertTrue(Arrays.asList(Move.values()).contains(move));
    }
  }

  @Test
  @DisplayName("Randomness over multiple calls")
  void testRandomness() {
    Set<Move> movesSeen = new HashSet<>();
    for (int i = 0; i < NUM_TRIALS; i++) {
      Move move = computerPlayer.getMove();
      movesSeen.add(move);
    }
    assertEquals(Move.values().length, movesSeen.size(), "Not all moves were chosen by the computer player, which might indicate a lack of randomness.");
  }
}
