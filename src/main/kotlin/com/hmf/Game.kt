package com.hmf

import java.util.Scanner

class Game<Opponent: IOpponent, Outputter: IOutputter> {

    private val scanner = Scanner(System.`in`)
    private val opponent: Opponent
    private val outputter: Outputter

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


    fun play(){
        var stopPlaying = false
        while (!stopPlaying) {
            print("Choose your input:\n'0' for ROCK\n'1' for PAPER\n'2' for SCISSORS\n'x' to stop\n -> ")
            val userInput = when (scanner.next().single()) {
                '0' -> Element.ROCK
                '1' -> Element.PAPER
                '2' -> Element.SCISSORS
                'x' -> {
                    outputter.printStats(getStats())
                    break
                }
                else -> {
                    println("Invalid input, fat fingers? Try again!")
                    continue
                }
            }
            playRound(userInput)
        }
    }

    fun getStats(): GameResult {
        return GameResult(roundsPlayed=played,roundsWon=won,roundsDrawn=drawn)
    }

}
