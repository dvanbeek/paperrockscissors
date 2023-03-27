package io.github.mdenburger.rockpaperscissors.domain

fun playGame(me: Player, opponent: Player): GameState {
    val state = GameState()

    while (true) {
        val myShape = me.getShape()
        val opponentShape = opponent.getShape()

        if (myShape != null && opponentShape != null) {
            val roundResult = playRound(myShape, opponentShape)
            state.recordRound(roundResult)

            me.noteLastRound(myShape, opponentShape, roundResult)
            opponent.noteLastRound(opponentShape, myShape, roundResult.opposite())
        } else {
            return state
        }
    }
}
