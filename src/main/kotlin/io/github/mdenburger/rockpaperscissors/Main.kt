package io.github.mdenburger.rockpaperscissors

import io.github.mdenburger.rockpaperscissors.ai.RandomPlayer
import io.github.mdenburger.rockpaperscissors.console.ConsolePlayer
import io.github.mdenburger.rockpaperscissors.domain.playGame

fun main() {
    val me = ConsolePlayer()
    val opponent = RandomPlayer()
    val gameState = playGame(me, opponent)
    println("Games won: ${gameState.wins}, lost: ${gameState.losses}, tied: ${gameState.ties}")
}
