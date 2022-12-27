import lombok.SneakyThrows;
import nl.hartwigmedical.exceptions.InvalidPlayerNameException;
import nl.hartwigmedical.players.ComputerPlayer;
import nl.hartwigmedical.players.HumanPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


@DisplayName("Player logic tests")
public class PlayerTest {

    @Test
    @SneakyThrows
    @DisplayName("Computer random name")
    public void testComputerPlayerWithRandomName() {
        Assertions.assertTrue(List.of("Joe", "Jimmy", "Randy").contains(new ComputerPlayer().getName()));
    }

    @Test
    @SneakyThrows
    @DisplayName("Invalid player name")
    public void testInvalidPlayerName() {
        Assertions.assertThrows(InvalidPlayerNameException.class, () -> {
            new HumanPlayer("This!s!nvalid1");
        });
    }

    @Test
    @SneakyThrows
    @DisplayName("Valid player name")
    public void testValidPlayerName() {
        Assertions.assertDoesNotThrow(() -> new HumanPlayer("John"));
    }
}
