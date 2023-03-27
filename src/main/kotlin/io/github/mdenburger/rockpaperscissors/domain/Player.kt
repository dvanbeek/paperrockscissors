package io.github.mdenburger.rockpaperscissors.domain

interface Player {

    /**
     * @return the shape to play, or null to quit the game
     */
    fun getShape(): Shape?

    /**
     * Notes the result of the last round, e.g to inform a human player of the result
     * or to adjust some automated strategy.
     */
    fun noteLastRound(myShape: Shape, opponentShape: Shape, result: RoundResult)
}
