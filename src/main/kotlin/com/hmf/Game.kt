package com.hmf

class Game<Opponent: ICanPlay, Outputter: ICanPrint> {

    val opponent: Opponent
    val outputter: Outputter

    constructor(opponent:Opponent,outputter:Outputter){
        this.opponent = opponent
        this.outputter = outputter
    }
    private var played:Int = 0;
    private var won:Int = 0;
    private var drawn:Int = 0;
    private val rules = GameRules()

    fun playRound(playerHand: Element) {
        val opponentHand = opponent.play()
        val outcome = rules.getOutcome(player = playerHand, opponent=opponentHand)
        outputter.printOutcome(roundOutcome=outcome, player = playerHand, opponent = opponentHand)
        when(outcome){
            Outcome.PLAYER_WON -> won+=1
            Outcome.DRAW ->  drawn+=1
            Outcome.PLAYER_LOST -> Unit
        }
        played+=1
    }

    fun getStats(): GameResult {
        return GameResult(roundsPlayed=played,roundsWon=won,roundsDrawn=drawn)
    }


}
