package games.rockpaperscissors;

import java.util.Arrays;
import java.util.List;

import games.IGame;
import games.IPlayer;
import games.ResultsEnum;
import games.inputs.FixedInput;
import games.players.Computer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPaperScissorsTest {
    
    @Test
    public void TestIfPlayerOneWinsWhenChoosingPaperOverRock()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.PAPER);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.ROCK);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.WIN, result);
    }

    @Test
    public void TestIfPlayerOneWinsWhenChoosingScissorsOverPaper()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.PAPER);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.WIN, result);
    }

    @Test
    public void TestIfPlayerOneWinsWhenChoosingRockOverScissors()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.ROCK);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.WIN, result);
    }

    @Test
    public void TestIfPlayerOneLosesWhenChoosingRockOverPaper()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.ROCK);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.PAPER);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.LOSS, result);
    }

    @Test
    public void TestIfPlayerOneLosesWhenChoosingPaperOverScissors()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.PAPER);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.LOSS, result);
    }

    @Test
    public void TestIfPlayerOneLosesWhenChoosingScissorsOverRock()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.ROCK);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.LOSS, result);
    }

    @Test
    public void TestIfPlayersTieWhenChoosingRocks()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.ROCK);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.ROCK);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.TIE, result);
    }

    @Test
    public void TestIfPlayersTieWhenChoosingPaper()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.PAPER);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.PAPER);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.TIE, result);
    }

    @Test
    public void TestIfPlayersTieWhenChoosingScissors()
    {
        // Arrange
        FixedInput inputPaper = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        FixedInput inputRock = new FixedInput(RockPaperScissorsOptions.SCISSORS);
        List<IPlayer> players = Arrays.asList(
            new Computer(inputPaper),
            new Computer(inputRock)
        );

        IGame game = new RockPaperScissors(players);

        // Act
        ResultsEnum result = game.play();
        // Assert
        assertEquals(ResultsEnum.TIE, result);
    }
}
