package io.github.mdenburger.rockpaperscissors.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.mdenburger.rockpaperscissors.domain.RoundResult.*
import io.github.mdenburger.rockpaperscissors.domain.Shape.*
import org.junit.jupiter.api.Test

class PlayRoundTest {
    @Test
    fun `play winning shape`() {
        assertThat(playRound(me = Rock, opponent = Scissors)).isEqualTo(Win)
        assertThat(playRound(me = Paper, opponent = Rock)).isEqualTo(Win)
        assertThat(playRound(me = Scissors, opponent = Paper)).isEqualTo(Win)
    }

    @Test
    fun `play loosing shape`() {
        assertThat(playRound(me = Rock, opponent = Paper)).isEqualTo(Loss)
        assertThat(playRound(me = Paper, opponent = Scissors)).isEqualTo(Loss)
        assertThat(playRound(me = Scissors, opponent = Rock)).isEqualTo(Loss)
    }

    @Test
    fun `play same shape results in a tie`() {
        for (shape in Shape.values()) {
            assertThat(playRound(me = shape, opponent = shape)).isEqualTo(Tie)
        }
    }
}
