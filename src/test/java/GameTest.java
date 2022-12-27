import nl.hartwigmedical.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game;
    @Test
    public void testInitGame(){
        game = Game.initGame();
        Assertions.assertNotNull(game);
    }

}
