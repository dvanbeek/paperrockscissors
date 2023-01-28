package com.mvanniekerk.rps;

import com.mvanniekerk.rps.match.Move;
import com.mvanniekerk.rps.match.Result;
import com.mvanniekerk.rps.match.Round;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static class RockStrategy implements Strategy {

        @Override
        public Move choice(List<Round> rounds) {
            return Move.parse("rock");
        }
    }

    @Test
    void gameRoundTest() {
        Game game = new Game(new RockStrategy());
        Round round = game.playRound(Move.parse("rock"));

        Assertions.assertEquals(Result.DRAW, round.getResultForPlayer());
        assertEquals(1, game.viewRounds().size());
        assertEquals("You won 0 times.\nYou lost 0 times.\nYou drew 1 times.\n", game.getStats().toString());
    }
}