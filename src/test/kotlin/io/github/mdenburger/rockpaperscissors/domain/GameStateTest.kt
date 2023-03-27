package io.github.mdenburger.rockpaperscissors.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.mdenburger.rockpaperscissors.domain.RoundResult.*
import org.junit.jupiter.api.Test

class GameStateTest {

    @Test
    fun `game state starts with zero wins, losses and ties`() {
        val initialState = GameState()

        assertThat(initialState.wins).isEqualTo(0)
        assertThat(initialState.losses).isEqualTo(0)
        assertThat(initialState.ties).isEqualTo(0)
    }

    @Test
    fun `game state counts wins, losses and ties`() {
        val gameState = GameState()
        gameState.recordRound(Win)
        gameState.recordRound(Loss)
        gameState.recordRound(Tie)
        gameState.recordRound(Win)
        gameState.recordRound(Loss)
        gameState.recordRound(Win)

        assertThat(gameState.wins).isEqualTo(3)
        assertThat(gameState.losses).isEqualTo(2)
        assertThat(gameState.ties).isEqualTo(1)
    }
}
