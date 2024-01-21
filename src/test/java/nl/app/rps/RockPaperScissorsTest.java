package nl.app.rps;

import nl.app.rps.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class RockPaperScissorsTest {

    @Mock
    Player player1;
    @Mock
    Player player2;
    @Mock
    GamePrinter mockPrinter;
    @Mock
    ScoreBoard mockScoreBoard;

    @Test
    void test_game_rock_beats_paper() {
        Mockito.when(player1.getInput()).thenReturn(GameOption.ROCK).thenReturn(GameOption.END);
        Mockito.when(player2.getInput()).thenReturn(GameOption.PAPER);

        new RockPaperScissors(player1, player2, mockPrinter, mockScoreBoard);

        Mockito.verify(mockPrinter).printResult(GameResult.LOSS, GameOption.ROCK.name(), GameOption.PAPER.name());
        Mockito.verify(mockScoreBoard).setLoss(anyInt());
        Mockito.verify(mockScoreBoard, Mockito.times(0)).setDraw(anyInt());
        Mockito.verify(mockScoreBoard, Mockito.times(0)).setWin(anyInt());
    }

    @Test
    void test_game_draw() {
        Mockito.when(player1.getInput()).thenReturn(GameOption.ROCK).thenReturn(GameOption.END);
        Mockito.when(player2.getInput()).thenReturn(GameOption.ROCK);


        new RockPaperScissors(player1, player2, mockPrinter, mockScoreBoard);

        Mockito.verify(mockPrinter).printResult(GameResult.DRAW, GameOption.ROCK.name(), GameOption.ROCK.name());
        Mockito.verify(mockScoreBoard).setDraw(anyInt());
    }

    @ParameterizedTest
    @CsvSource({
            "ROCK,ROCK,DRAW",
            "ROCK,PAPER,LOSS",
            "ROCK,SCISSORS,WIN",
            "PAPER,PAPER,DRAW",
            "PAPER,ROCK,WIN",
            "PAPER,SCISSORS,LOSS",
            "SCISSORS,SCISSORS,DRAW",
            "SCISSORS,ROCK,LOSS",
            "SCISSORS,PAPER,WIN"
    })
    void csvSourceTest(String player1Input, String player2Input, String result) {
        GameOption player1GameOption = GameOption.valueOf(player1Input);
        GameOption player2GameOption = GameOption.valueOf(player2Input);
        GameResult gameResult = GameResult.valueOf(result);

        Mockito.when(player1.getInput()).thenReturn(player1GameOption).thenReturn(GameOption.END);
        Mockito.when(player2.getInput()).thenReturn(player2GameOption);


        new RockPaperScissors(player1, player2, mockPrinter, mockScoreBoard);

        Mockito.verify(mockPrinter).printResult(gameResult, player1GameOption.name(), player2GameOption.name());
    }
}