import java.util.*

fun runGame(
    playerA: Player,
    playerB: Player,
    gui: Gui,
    matchupDecider: MatchupDecider = DefaultMatchupDecider
) {
    val matchupLogs = Stack<MatchupLog>()
    try {
        while (true) {
            val playerAChoice = playerA.pickChoiceThrowing(gui)
            gui.showPlayerChoiceFeedback(playerA, playerAChoice)
            val playerBChoice = playerB.pickChoiceThrowing(gui)
            gui.showPlayerChoiceFeedback(playerB, playerBChoice)
            val matchupResult = matchupDecider.decide(playerA, playerAChoice, playerB, playerBChoice)
            gui.showMatchupResult(matchupResult)
            matchupLogs.add(MatchupLog(playerAChoice, playerBChoice, matchupResult))
        }
    } catch (e: ExitPickChoice) {
    }
    gui.showMatchupLogs(playerA, playerB, matchupLogs)
}
