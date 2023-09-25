package com.hmf

interface IOutputter {
    fun printOutcome(roundOutcome: Outcome, player: Element, opponent: Element)
    fun printStats(stats:GameResult)
}
