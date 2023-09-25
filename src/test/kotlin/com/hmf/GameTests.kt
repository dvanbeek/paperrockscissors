package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StubOpponent : ICanPlay {
    override fun play(): Element {
        return Element.ROCK;
    }
}

class GameTests {

    @Test
    fun TestStatsForGameNotPlayed(){
        val opponent = StubOpponent()
        val game = Game<StubOpponent>(opponent)
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 0)
        assertEquals(result.roundsWon, 0)
        assertEquals(result.roundsDrawn, 0)
    }

    @Test
    fun TestStatsForMultiplePlayedGameRounds(){
        val opponent = StubOpponent()
        val game = Game<StubOpponent>(opponent)
        game.playRound(playerHand=Element.SCISSORS)
        game.playRound(playerHand=Element.ROCK)
        game.playRound(playerHand=Element.PAPER)
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 3)
        assertEquals(result.roundsWon, 1)
        assertEquals(result.roundsDrawn, 1)
    }


}