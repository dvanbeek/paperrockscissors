package com.hmf

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StubOpponent(val element: Element) : ICanPlay {
    override fun play(): Element {
        return element;
    }
}
class StubOutputter : ICanPrint {
    override fun printOutcome(roundOutcome: Outcome, player: Element, opponent: Element) {}
}

class GameTests {

    val alwaysRockOpponent = StubOpponent(Element.ROCK)
    val outputter = StubOutputter()

    @Test
    fun TestStatsForGameNotPlayed(){
        val game = Game<StubOpponent, StubOutputter>(alwaysRockOpponent,outputter)
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 0)
        assertEquals(result.roundsWon, 0)
        assertEquals(result.roundsDrawn, 0)
    }

    @Test
    fun TestStatsForMultiplePlayedGameRounds(){
        val game = Game<StubOpponent, StubOutputter>(alwaysRockOpponent,outputter)
        game.playRound(playerHand=Element.SCISSORS)
        game.playRound(playerHand=Element.ROCK)
        game.playRound(playerHand=Element.PAPER)
        val result = game.getStats()
        assertEquals(result.roundsPlayed, 3)
        assertEquals(result.roundsWon, 1)
        assertEquals(result.roundsDrawn, 1)
    }


}