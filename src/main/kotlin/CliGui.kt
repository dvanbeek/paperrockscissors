import java.io.PrintStream
import java.io.Reader

class CliGui(
    input: Reader,
    private val output: PrintStream
) : Gui {
    private val input = input.buffered()

    override fun awaitUserChoicePick(): ChoicePick {
        val choiceDisplayNames = Choice.entries.map { it.displayName }.joinToString("/")
        while (true) {
            output.print("Pick ($choiceDisplayNames), or \"${ChoicePick.Exit.DISPLAY_NAME}\" to end the game: ")
            val choiceString = input.readLine()
            if (choiceString == ChoicePick.Exit.DISPLAY_NAME) {
                return ChoicePick.Exit
            }
            val choiceMaybe = Choice.entries.find { it.displayName == choiceString }
            if (choiceMaybe != null) {
                return ChoicePick.AChoice(choiceMaybe)
            }
            output.println("Please pick a valid answer.")
        }
    }

    override fun showMatchupLogs(playerA: Player, playerB: Player, matchupLogs: Collection<MatchupLog>) {
        val matchupLogsString = matchupLogs
            .map { matchupLog ->
                mapOf(
                    playerA.displayName to matchupLog.playerAChoice.displayName,
                    playerB.displayName to matchupLog.playerBChoice.displayName,
                    "Result" to matchupLog.matchupResult.displayName
                )
                    .entries
                    .map { arrayOf(it.key, it.value).joinToString(": ") }
                    .joinToString(" | ")
            }
            .joinToString("\n")
        output.println(matchupLogsString)
    }

    override fun showPlayerChoiceFeedback(player: Player, choice: Choice) {
        output.println("${player.displayName} picked ${choice.displayName}")
    }

    override fun showMatchupResult(matchupResult: MatchupResult) {
        output.println(matchupResult.displayName)
    }
}
