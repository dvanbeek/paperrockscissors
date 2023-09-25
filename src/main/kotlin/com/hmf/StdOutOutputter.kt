package com.hmf

class StdOutOutputter : ICanPrint {
    override fun printOutcome(roundOutcome: Outcome, player: Element, opponent: Element) {
        when(roundOutcome){
            Outcome.PLAYER_LOST ->
                println("You lost! ${player.toString()} looses to ${opponent.toString()}")
            Outcome.PLAYER_WON ->
                println("You won! ${player.toString()} beats ${opponent.toString()}")
            Outcome.DRAW ->
                println("It is a draw! Computer played ${opponent.toString()} as well.")
        }
    }
}