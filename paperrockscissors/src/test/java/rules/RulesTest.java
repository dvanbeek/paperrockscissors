package rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import score.Outcome;

import static score.Outcome.*;
import static shapes.Shape.*;

class RulesTest {
    @Test
    void playRound() {
        Outcome win1 = Rules.playRound(PAPER, ROCK);
        Outcome win2 = Rules.playRound(ROCK, SCISSORS);
        Outcome win3 = Rules.playRound(SCISSORS, PAPER);
        Outcome loss1 = Rules.playRound(SCISSORS, ROCK);
        Outcome loss2 = Rules.playRound(PAPER, SCISSORS);
        Outcome loss3 = Rules.playRound(ROCK, PAPER);
        Outcome tie1 = Rules.playRound(PAPER, PAPER);
        Outcome tie2 = Rules.playRound(ROCK, ROCK);
        Outcome tie3 = Rules.playRound(SCISSORS, SCISSORS);
        Assertions.assertAll("3 wins, 3 losses, 3 ties",
                () -> Assertions.assertEquals(WIN, win1),
                () -> Assertions.assertEquals(WIN, win2),
                () -> Assertions.assertEquals(WIN, win3),
                () -> Assertions.assertEquals(LOSE, loss1),
                () -> Assertions.assertEquals(LOSE, loss2),
                () -> Assertions.assertEquals(LOSE, loss3),
                () -> Assertions.assertEquals(TIE, tie1),
                () -> Assertions.assertEquals(TIE, tie2),
                () -> Assertions.assertEquals(TIE, tie3)
        );
    }
}