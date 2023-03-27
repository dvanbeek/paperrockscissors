package io.github.mdenburger.rockpaperscissors.ai

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class RandomPlayerTest {
    @Test
    fun `get a random move without exceptions`() {
        val player = RandomPlayer()
        repeat(100) {
            assertDoesNotThrow {
                player.getShape()
            }
        }
    }
}
