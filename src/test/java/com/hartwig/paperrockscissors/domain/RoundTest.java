package com.hartwig.paperrockscissors.domain;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void constructor_shouldThrowExceptionIfMultipleMovesBySamePlayer() {
        // Arrange
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Move move1 = new Move(player1, Choice.ROCK);
        Move move2 = new Move(player2, Choice.PAPER);
        Move move3 = new Move(player1, Choice.SCISSORS);
        List<Move> moves = List.of(move1, move2, move3);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> new Round(moves));
    }

    @Test
    void constructor_shouldNotThrowExceptionIfOneMovePerPlayer() {
        // Arrange
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Move move1 = new Move(player1, Choice.ROCK);
        Move move2 = new Move(player2, Choice.PAPER);
        List<Move> moves = List.of(move1, move2);

        // Act & Assert
        assertDoesNotThrow(() -> new Round(moves));
    }
}
