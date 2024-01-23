interface Gui {
    fun awaitUserChoicePick(): ChoicePick
    fun showMatchupLogs(playerA: Player, playerB: Player, matchupLogs: Collection<MatchupLog>)
    fun showPlayerChoiceFeedback(player: Player, choice: Choice)
    fun showMatchupResult(matchupResult: MatchupResult)
}
