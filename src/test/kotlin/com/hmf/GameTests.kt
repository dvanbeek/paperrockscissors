package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StubOpponent : ICanPlay {
    override fun play(): Element {
        TODO("Not yet implemented")
    }
}

class GameTests {

    @Test
    fun TestStatsForGameNotPlayed(){
        val game = Game()
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 0)
        assertEquals(result.roundsWon, 0)
        assertEquals(result.roundsDrawn, 0)
    }

    @Test
    fun TestStatsForMultiplePlayedGameRounds(){
        val game = Game<StubOpponent>()
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 0)
        assertEquals(result.roundsWon, 0)
        assertEquals(result.roundsDrawn, 0)
    }


}