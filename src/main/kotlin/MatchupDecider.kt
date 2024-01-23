/**
 * Allows for more fine grain control than defining a "wins"-method on [Choice] as well as easier representation of [MatchupResult.Tie] result.
 */
interface MatchupDecider {
    fun decide(playerA: Player, choiceA: Choice, playerB: Player, choiceB: Choice): MatchupResult
}
