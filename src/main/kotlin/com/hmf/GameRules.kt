package com.hmf

class GameRules {

    private val rules: Array<Array<Outcome>> = arrayOf(
        arrayOf(Outcome.DRAW,        Outcome.PLAYER_LOST, Outcome.PLAYER_WON),
        arrayOf(Outcome.PLAYER_WON,  Outcome.DRAW,        Outcome.PLAYER_LOST),
        arrayOf(Outcome.PLAYER_LOST, Outcome.PLAYER_WON,  Outcome.DRAW)
    )

    fun getOutcome(player: Element, opponent: Element): Outcome {
        require(player.idx in 0..2)
        require(opponent.idx in 0..2)
        return rules[player.idx][opponent.idx]
    }
}
