import lombok.SneakyThrows;
import nl.hartwigmedical.Game;
import nl.hartwigmedical.HumanPlayer;
import nl.hartwigmedical.TooManyPLayersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.fail;

public class GameTest {

    Game game;

    @Test
    @SneakyThrows
    public void testInitGame(){
        game = Game.initGame();
        Assertions.assertNotNull(game);
    }


    public void  testAskForPlayerName() {
        fail("Not implemenetd");
    }

    @Test
    @SneakyThrows
    public void testShouldThrowExceptionIfTooManyPlayer() {
        game = Game.initGame();
        Assertions.assertThrows(TooManyPLayersException.class, ()-> {
            game.addPlayer(new HumanPlayer("Martijn"));
            game.addPlayer(new HumanPlayer("ThreeIsACrowd"));
        });
    }


}
