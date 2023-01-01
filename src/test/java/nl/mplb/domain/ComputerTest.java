package nl.mplb.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComputerTest {
  @Test
  void testMakeMoveHappyPath() {
    Computer computer = new Computer();
    assertNull(computer.getChosenMove(), "Should construct without a move");
    computer.makeMove();
    assertNotNull(computer.getChosenMove(), "Should have a move after making a move");
  }
}
