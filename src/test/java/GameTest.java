import lombok.SneakyThrows;
import nl.hartwigmedical.exceptions.TooManyPLayersException;
import nl.hartwigmedical.game.Choice;
import nl.hartwigmedical.game.Game;
import nl.hartwigmedical.players.ComputerPlayer;
import nl.hartwigmedical.players.HumanPlayer;
import nl.hartwigmedical.players.Player;
import org.javatuples.Pair;
import org.junit.jupiter.api.*;

import java.util.Optional;

@DisplayName("Game logic tests")
public class GameTest {

    private Game game;

    @BeforeEach
    @SneakyThrows
    public void setup() {
        game = Game.initGame();
    }

    @AfterEach
    public void tearDown(){
        game = null;
    }

    @Test
    @SneakyThrows
    @DisplayName("Test game initialisation")
    public void testInitGame() {
        Assertions.assertNotNull(game);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test maximum player limit in game")
    public void testShouldThrowExceptionIfTooManyPlayer() {
        Assertions.assertThrows(TooManyPLayersException.class, () -> {
            game.addPlayer(new HumanPlayer("Martijn"));
            game.addPlayer(new HumanPlayer("ThreeIsACrowd"));
        });
    }

    @DisplayName("Test paper beats rock")
    @SneakyThrows
    @Test
    public void testPaperShouldBeatRock(){
        String playerName = "Test";
        Pair<Player, Choice> humanPlayerChoice = new Pair<>(new HumanPlayer(playerName), Choice.PAPER);
        Pair<Player, Choice> computerPlayerChoice = new Pair<>(new ComputerPlayer(), Choice.ROCK);
        Optional<Player> winner = game.determineWinner.apply(humanPlayerChoice, computerPlayerChoice);
        Assertions.assertEquals(winner.get().getName(), playerName);
    }

    @DisplayName("Test rock beats scissors")
    @SneakyThrows
    @Test
    public void testRockShouldBeatScissors(){
        String playerName = "Mister";
        Pair<Player, Choice> humanPlayerChoice = new Pair<>(new HumanPlayer(playerName), Choice.ROCK);
        Pair<Player, Choice> computerPlayerChoice = new Pair<>(new ComputerPlayer(), Choice.SCISSORS);
        Optional<Player> winner = game.determineWinner.apply(humanPlayerChoice, computerPlayerChoice);
        Assertions.assertEquals(winner.get().getName(), playerName);
    }

    @DisplayName("Test scissors beats paper")
    @SneakyThrows
    @Test
    public void testScissorsShouldBeatPaper(){
        String playerName = "Patatohead";
        Pair<Player, Choice> humanPlayerChoice = new Pair<>(new HumanPlayer(playerName), Choice.SCISSORS);
        Pair<Player, Choice> computerPlayerChoice = new Pair<>(new ComputerPlayer(), Choice.PAPER);
        Optional<Player> winner = game.determineWinner.apply(humanPlayerChoice, computerPlayerChoice);
        Assertions.assertEquals(winner.get().getName(), playerName);
    }

}
