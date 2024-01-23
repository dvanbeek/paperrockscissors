/**
 * This class allows for more explicit wording compared to say, a comparison result in the form of -1, 0, 1.
 */
sealed class MatchupResult(val displayName: String) {
    data class WinningPlayer(val player: Player) : MatchupResult("${player.displayName} wins")
    data object Tie : MatchupResult("tie")
}
