import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EvaluatorTest {

    @Mock
    Player player;

    // Player uses move "Rock" tests x3
    @Test
    public void evaluateWinner_PlayerUsesRockCompUsesPaper_ResultCompWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.ROCK, Move.PAPER);

        verify(game, times(1)).computerWins();
    }

    @Test
    public void evaluateWinner_PlayerUsesRockCompUsesRock_ResultDraw() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.ROCK, Move.ROCK);

        verify(game, times(1)).drawResult();
    }

    @Test
    public void evaluateWinner_PlayerUsesRockCompUsesScissors_ResultPlayerWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.ROCK, Move.SCISSORS);

        verify(game, times(1)).playerWins();
    }

    // Player uses move "Scissors" tests x3
    @Test
    public void evaluateWinner_PlayerUsesScissorsCompUsesPaper_ResultPlayerWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.SCISSORS, Move.PAPER);

        verify(game, times(1)).playerWins();
    }

    @Test
    public void evaluateWinner_PlayerUsesScissorsCompUsesRock_ResultCompWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.SCISSORS, Move.ROCK);

        verify(game, times(1)).computerWins();
    }

    @Test
    public void evaluateWinner_PlayerUsesScissorsCompUsesScissors_ResultDraw() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.SCISSORS, Move.SCISSORS);

        verify(game, times(1)).drawResult();
    }

    // Player uses move "Paper" tests x3
    @Test
    public void evaluateWinner_PlayerUsesPaperCompUsesScissors_ResultCompWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.PAPER, Move.SCISSORS);

        verify(game, times(1)).computerWins();
    }

    @Test
    public void evaluateWinner_PlayerUsesPaperCompUsesPaper_ResultDraw() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.PAPER, Move.PAPER);

        verify(game, times(1)).drawResult();
    }

    @Test
    public void evaluateWinner_PlayerUsesPaperCompUsesRock_PlayerWins() {
        Game game = Mockito.spy(new Game(player));

        Evaluator.evaluateWinner(game, Move.PAPER, Move.ROCK);

        verify(game, times(1)).playerWins();
    }

}