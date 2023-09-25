package com.hmf

class Game {

    private var played:Int = 0;
    private var won:Int = 0;
    private var drawn:Int = 0;

    fun playRound(playerHand: Element) {

    }

    fun getStats(): GameResult {
        return GameResult(roundsPlayed=played,roundsWon=won,roundsDrawn=drawn)
    }


}
