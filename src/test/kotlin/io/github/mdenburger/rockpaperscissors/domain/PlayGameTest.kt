package io.github.mdenburger.rockpaperscissors.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.mdenburger.rockpaperscissors.domain.RoundResult.Loss
import io.github.mdenburger.rockpaperscissors.domain.RoundResult.Win
import io.github.mdenburger.rockpaperscissors.domain.Shape.*
import org.junit.jupiter.api.Test

class PlayGameTest {

    @Test
    fun `play zero rounds`() {
        val me = TestPlayer()
        val opponent = TestPlayer()

        // act
        val gameState = playGame(me, opponent)

        assertThat(gameState.wins).isEqualTo(0)
        assertThat(gameState.losses).isEqualTo(0)
        assertThat(gameState.ties).isEqualTo(0)
    }

    @Test
    fun `play one round`() {
        val me = TestPlayer(Rock)
        val opponent = TestPlayer(Scissors)

        // act
        val gameState = playGame(me, opponent)

        assertThat(me.myLastShape).isEqualTo(Rock)
        assertThat(me.opponentLastShape).isEqualTo(Scissors)
        assertThat(me.lastRoundResult).isEqualTo(Win)

        assertThat(opponent.myLastShape).isEqualTo(Scissors)
        assertThat(opponent.opponentLastShape).isEqualTo(Rock)
        assertThat(opponent.lastRoundResult).isEqualTo(Loss)

        assertThat(gameState.wins).isEqualTo(1)
        assertThat(gameState.losses).isEqualTo(0)
        assertThat(gameState.ties).isEqualTo(0)
    }

    @Test
    fun `play two rounds`() {
        val me = TestPlayer(Rock, Paper)
        val opponent = TestPlayer(Rock, Scissors)

        // act
        val gameState = playGame(me, opponent)

        assertThat(me.myLastShape).isEqualTo(Paper)
        assertThat(me.opponentLastShape).isEqualTo(Scissors)
        assertThat(me.lastRoundResult).isEqualTo(Loss)

        assertThat(opponent.myLastShape).isEqualTo(Scissors)
        assertThat(opponent.opponentLastShape).isEqualTo(Paper)
        assertThat(opponent.lastRoundResult).isEqualTo(Win)

        assertThat(gameState.wins).isEqualTo(0)
        assertThat(gameState.losses).isEqualTo(1)
        assertThat(gameState.ties).isEqualTo(1)
    }
}

private class TestPlayer(vararg val shapes: Shape?) : Player {
    private var round = 0
    var myLastShape: Shape? = null
    var opponentLastShape: Shape? = null
    var lastRoundResult: RoundResult? = null

    override fun getShape(): Shape? =
        if (round < shapes.size) {
            shapes[round].also { round += 1 }
        } else {
            null
        }

    override fun noteLastRound(myShape: Shape, opponentShape: Shape, result: RoundResult) {
        myLastShape = myShape
        opponentLastShape = opponentShape
        lastRoundResult = result
    }
}