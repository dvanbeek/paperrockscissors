package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameRulesTests {

    @Test
    fun TestSingleRound(){
        val round = GameRules()
        val outcome0 = round.getOutcome(player=Element.ROCK, opponent=Element.ROCK)
        assertEquals(outcome0, Outcome.DRAW)

        val outcome1 = round.getOutcome(player=Element.ROCK, opponent=Element.PAPER)
        assertEquals(outcome1, Outcome.PLAYER_LOST)

        val outcome2 = round.getOutcome(player=Element.ROCK, opponent=Element.SCISSORS)
        assertEquals(outcome2, Outcome.PLAYER_WON)
    }
}