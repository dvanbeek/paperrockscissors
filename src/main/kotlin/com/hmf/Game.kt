package com.hmf

class Game<Opponent: ICanPlay> {

    val opponent: Opponent

    constructor(opponent:Opponent){
        this.opponent = opponent
    }
    private var played:Int = 0;
    private var won:Int = 0;
    private var drawn:Int = 0;
    private val rules = GameRules()

    fun playRound(playerHand: Element) {
        val opponentHand = opponent.play()
        when(rules.getOutcome(player = playerHand, opponent=opponentHand)){
            Outcome.PLAYER_WON -> {
                println("You won! ${playerHand.toString()} beats ${opponentHand.toString()}")
                won+=1
            }
            Outcome.PLAYER_LOST -> {
                println("You lost! ${playerHand.toString()} looses to ${opponentHand.toString()}")
            }
            Outcome.DRAW -> {
                println("It is a draw! Computer played ${opponentHand.toString()} as well.")
                drawn+=1
            }
        }
        played+=1
    }

    fun getStats(): GameResult {
        return GameResult(roundsPlayed=played,roundsWon=won,roundsDrawn=drawn)
    }


}
