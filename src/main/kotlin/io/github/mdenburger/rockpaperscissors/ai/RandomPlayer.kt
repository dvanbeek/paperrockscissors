package io.github.mdenburger.rockpaperscissors.ai

import io.github.mdenburger.rockpaperscissors.domain.Player
import io.github.mdenburger.rockpaperscissors.domain.RoundResult
import io.github.mdenburger.rockpaperscissors.domain.Shape
import kotlin.random.Random

/**
 * Computer player that chooses a shape at random.
 */
class RandomPlayer : Player {

    // cache shapes to avoid unnecessary copies
    private val shapes = Shape.values()

    override fun getShape(): Shape =
        shapes[Random.nextInt(shapes.size)]

    override fun noteLastRound(myShape: Shape, opponentShape: Shape, result: RoundResult) {
        // Do nothing. A more sophisticated algorithm could track the shapes
        // played by the opponent and exploit non-random behavior.
    }
}
