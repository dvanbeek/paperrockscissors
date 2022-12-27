import lombok.SneakyThrows;
import nl.hartwigmedical.Game;
import nl.hartwigmedical.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PlayerTest {

    @Test
    @SneakyThrows
    public void testComputerPlayerWithRandomName(){
        Game game = Game.initGame();
        Player player = game.getPlayers().get(0);
        Assertions.assertTrue(List.of("Joe","Jimmy","Randy").contains(player.getName()));
    }
}
