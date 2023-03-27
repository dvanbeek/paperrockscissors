package io.github.mdenburger.rockpaperscissors.console

import io.github.mdenburger.rockpaperscissors.domain.Player
import io.github.mdenburger.rockpaperscissors.domain.RoundResult
import io.github.mdenburger.rockpaperscissors.domain.Shape

/**
 * Player that receives the shape to play as text input.
 */
class ConsolePlayer : Player {
    override fun getShape(): Shape? =
        readShapeOrNull()

    override fun noteLastRound(myShape: Shape, opponentShape: Shape, result: RoundResult) {
        println(
            "You played ${myShape.description()}, " +
                    "opponent played ${opponentShape.description()} " +
                    "so ${result.explanation()}"
        )
    }
}

private fun Shape.description(): String =
    this.toString().lowercase()

private fun RoundResult.explanation(): String =
    when (this) {
        RoundResult.Win -> "you win"
        RoundResult.Loss -> "you loose"
        RoundResult.Tie -> "it's a tie"
    }
