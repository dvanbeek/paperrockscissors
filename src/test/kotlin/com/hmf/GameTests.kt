package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTests {

    @Test
    fun TestStatsForGameNotPlayed(){
        val game = Game()
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 0)
        assertEquals(result.roundsWon, 0)
        assertEquals(result.roundsDrawn, 0)
    }


}