package io.github.mdenburger.rockpaperscissors.console

import io.github.mdenburger.rockpaperscissors.domain.Shape

private val shapeInput = mapOf(
    'r' to Shape.Rock,
    'p' to Shape.Paper,
    's' to Shape.Scissors
)

fun readShapeOrNull(): Shape? {
    print("Play [r]ock, [p]aper or [s]cissors? (or anything else to quit) > ")
    return readlnOrNull()?.let { parseShapeOrNull(it) }
}

fun parseShapeOrNull(input: String): Shape? {
    val sanitizedInput = input.trimStart().lowercase()

    for ((character, shape) in shapeInput) {
        if (sanitizedInput.startsWith(character)) {
            return shape
        }
    }

    return null
}
