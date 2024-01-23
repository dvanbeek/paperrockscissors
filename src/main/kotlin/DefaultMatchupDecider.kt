data object DefaultMatchupDecider : MatchupDecider {
    override fun decide(playerA: Player, choiceA: Choice, playerB: Player, choiceB: Choice): MatchupResult {
        val matchupResult = if (choiceA == choiceB) {
            MatchupResult.Tie
        } else {
            // For Lizard/Spock extension, update the right side of the pairs so that they are List<Choice> rather than just Choice
            val winTable = mapOf(
                Choice.ROCK to Choice.SCISSORS,
                Choice.PAPER to Choice.ROCK,
                Choice.SCISSORS to Choice.PAPER
            )
            val winningPlayer = if (winTable[choiceA] == choiceB) playerA else playerB
            MatchupResult.WinningPlayer(winningPlayer)
        }
        return matchupResult
    }
}
