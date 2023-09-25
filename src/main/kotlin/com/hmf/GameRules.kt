package com.hmf

class GameRules {

    private val rules: Array<Array<Outcome>> = arrayOf(
        arrayOf(Outcome.DRAW,        Outcome.PLAYER_LOST, Outcome.PLAYER_WON),
        arrayOf(Outcome.PLAYER_WON,  Outcome.DRAW,        Outcome.PLAYER_LOST),
        arrayOf(Outcome.PLAYER_LOST, Outcome.PLAYER_WON,  Outcome.DRAW)
    )

    fun getOutcome(player: Element, opponent: Element): Outcome {
        return rules[player.idx][opponent.idx]
    }
}
