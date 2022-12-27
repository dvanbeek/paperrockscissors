import lombok.SneakyThrows;
import nl.hartwigmedical.Game;
import nl.hartwigmedical.HumanPlayer;
import nl.hartwigmedical.TooManyPLayersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Game logic tests")
public class GameTest {

    Game game;
    private InputStream keyBoardIn = System.in;


    @BeforeEach
    public void setup() {

    }
    @Test
    @SneakyThrows
    @DisplayName("Test game initialisation")
    public void testInitGame(){
        game = Game.initGame();
        Assertions.assertNotNull(game);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test human player name")
    public void  testAskForPlayerName() {
        game = Game.initGame();

        final String playerName = "Rex";
        providePlayerInput(playerName);
        Scanner scanner = new Scanner(System.in);
        game.askForHumanPlayerName(scanner);

        Assertions.assertEquals(2,game.getPlayers().size());
        Assertions.assertEquals(game.getHumanPlayerFromGame().getName(), playerName);
        scanner.close();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test maximum player limit in game")
    public void testShouldThrowExceptionIfTooManyPlayer() {
        game = Game.initGame();
        Assertions.assertThrows(TooManyPLayersException.class, ()-> {
            game.addPlayer(new HumanPlayer("Martijn"));
            game.addPlayer(new HumanPlayer("ThreeIsACrowd"));
        });
    }


    private void providePlayerInput(String data) {
        keyBoardIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(keyBoardIn);
    }

}
