package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameRoundTests {

    @Test
    fun TestSingleRound(){

        val round = GameRound()
        val outcome0 = round.getOutcome(Element.ROCK, Element.ROCK)
        assertEquals(outcome0, Outcome.DRAW)

    }
}