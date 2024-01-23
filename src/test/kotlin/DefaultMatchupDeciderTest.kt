import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class DefaultMatchupDeciderTest {
    @Test
    fun `decides correctly`() {
        val playerA = instantiateStubPlayer("Arie")
        val playerB = instantiateStubPlayer("Hartwig")

        val d = DefaultMatchupDecider::decide

        fun MatchupResult.assertWinner(expectedWinningPlayer: Player) {
            assertIs<MatchupResult.WinningPlayer>(this)
            assertEquals(expectedWinningPlayer, this.player)
        }

        assertIs<MatchupResult.Tie>(d(playerA, Choice.ROCK, playerB, Choice.ROCK))
        assertIs<MatchupResult.Tie>(d(playerA, Choice.PAPER, playerB, Choice.PAPER))
        assertIs<MatchupResult.Tie>(d(playerA, Choice.SCISSORS, playerB, Choice.SCISSORS))
        d(playerA, Choice.ROCK, playerB, Choice.PAPER).assertWinner(playerB)
        d(playerA, Choice.ROCK, playerB, Choice.SCISSORS).assertWinner(playerA)
        d(playerA, Choice.PAPER, playerB, Choice.ROCK).assertWinner(playerA)
        d(playerA, Choice.PAPER, playerB, Choice.SCISSORS).assertWinner(playerB)
        d(playerA, Choice.SCISSORS, playerB, Choice.ROCK).assertWinner(playerB)
        d(playerA, Choice.SCISSORS, playerB, Choice.PAPER).assertWinner(playerA)
    }
}
