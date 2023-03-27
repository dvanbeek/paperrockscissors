package io.github.mdenburger.rockpaperscissors.domain

import io.github.mdenburger.rockpaperscissors.domain.RoundResult.*

class GameState {
    var wins: Int = 0
        private set
    var losses: Int = 0
        private set
    var ties: Int = 0
        private set

    fun recordRound(result: RoundResult): Unit =
        when (result) {
            Win -> wins += 1
            Loss -> losses += 1
            Tie -> ties += 1
        }
}
