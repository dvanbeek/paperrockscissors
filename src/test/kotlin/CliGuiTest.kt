import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.Reader
import kotlin.test.assertEquals
import kotlin.test.assertIs

class CliGuiTest {
    /**
     * So we avoid repetition. Return [ByteArrayOutputStream] in order to inspect output.
     */
    private fun cliGuiFactory(inputString: String = ""): Pair<CliGui, ByteArrayOutputStream> =
        cliGuiFactory(inputString.reader())

    /**
     * So we avoid repetition. Return [ByteArrayOutputStream] in order to inspect output. [Reader] param allows user
     * to spy on the input.
     */
    private fun cliGuiFactory(reader: Reader): Pair<CliGui, ByteArrayOutputStream> {
        val baos = ByteArrayOutputStream()
        val cliGui = CliGui(
            reader,
            PrintStream(baos)
        )
        return cliGui to baos
    }

    /**
     * Runs [CliGui.awaitUserChoicePick] method with string provided by user as input.
     * @return result of [CliGui.awaitUserChoicePick] if the input was valid or alternatively null, as well as the output string
     */
    private fun stubRunAwaitUserChoicePick(userInput: String): Pair<ChoicePick?, String> {
        val brSpy = spyk("$userInput\n".reader().buffered())

        // Have second call to buffered reader's readLine throw a special exception in order to break the "get user input until its valid"-loop
        run {
            var callCounter = 0
            every { brSpy.readLine() } answers {
                callCounter++
                if (callCounter == 2) {
                    throw StopAwaitingUserChoicePick
                }
                callOriginal()
            }
        }

        val (cliGui, baos) = cliGuiFactory(brSpy)
        try {
            val returnValue = cliGui.awaitUserChoicePick()
            return returnValue to baos.toString()
        } catch (e: StopAwaitingUserChoicePick) {
        }
        return null to baos.toString()
    }

    /**
     * Special exception that allows us to get out of the [CliGui.awaitUserChoicePick]-loop without needing to resort to passing in the [ChoicePick.Exit] command,
     * because then we wouldn't be able to test in isolation.
     */
    private data object StopAwaitingUserChoicePick : Exception()

    /**
     * Avoids repetition.
     */
    private val pickChoiceLine = run {
        val choiceEntriesJoined = Choice.entries.map { it.displayName }.joinToString("/")
        "Pick ($choiceEntriesJoined), or \"${ChoicePick.Exit.DISPLAY_NAME}\" to end the game: "
    }

    @Test
    fun `awaitUserChoicePick outputs correct response on invalid input`() {
        val (_, output) = stubRunAwaitUserChoicePick("some invalid answer")
        assertEquals(
            "${pickChoiceLine}Please pick a valid answer.",
            output.lineSequence().first()
        )
    }

    @Test
    fun `awaitUserChoicePick outputs correct response on valid input`() {
        Choice.entries.map { it.displayName }.forEach { userInput ->
            val (_, output) = stubRunAwaitUserChoicePick(userInput)
            assertEquals(
                pickChoiceLine,
                output.lineSequence().first()
            )
        }
    }

    @Test
    fun `awaitUserChoicePick returns correct UserInput on choice input`() {
        Choice.entries.map { it }.forEach { userInput ->
            val (returnValue) = stubRunAwaitUserChoicePick(userInput.displayName)
            assertIs<ChoicePick.AChoice>(returnValue)
            assertEquals(
                userInput,
                returnValue.choice
            )
        }
    }

    @Test
    fun `awaitUserChoicePick returns correct UserInput on exit input`() {
        val (returnValue) = stubRunAwaitUserChoicePick(ChoicePick.Exit.DISPLAY_NAME)
        assertIs<ChoicePick.Exit>(returnValue)
    }

    @Test
    fun `showPlayerChoiceFeedback outputs correct response`() {
        val player = instantiateStubPlayer()
        Choice.entries.forEach { choice ->
            val (cliGui, baos) = cliGuiFactory()
            cliGui.showPlayerChoiceFeedback(player, choice)
            assertEquals("${player.displayName} picked ${choice.displayName}", baos.toString().lineSequence().first())
        }
    }

    @Test
    fun `showMatchupResult outputs correct response`() {
        arrayOf(MatchupResult.Tie, MatchupResult.WinningPlayer(instantiateStubPlayer())).forEach {
            val (cliGui, baos) = cliGuiFactory()
            val matchupResult = MatchupResult.Tie
            cliGui.showMatchupResult(matchupResult)
            assertEquals(matchupResult.displayName, baos.toString().lineSequence().first())
        }
    }

    @Test
    fun `showMatchupLogs outputs correct response`() {
        val playerA = instantiateStubPlayer("Arie")
        val playerB = instantiateStubPlayer("Hartwig")

        fun getOutputForMatchupLogs(matchupLogs: List<MatchupLog>): String {
            val (cliGui, baos) = cliGuiFactory()
            cliGui.showMatchupLogs(playerA, playerB, matchupLogs)
            return baos.toString()
        }

        assertEquals("", getOutputForMatchupLogs(emptyList()).lineSequence().first())

        val nonEmptyMatchupLogLists = listOf(
            MatchupLog(Choice.PAPER, Choice.ROCK, MatchupResult.WinningPlayer(playerA)),
            MatchupLog(Choice.PAPER, Choice.ROCK, MatchupResult.WinningPlayer(playerA))
        )
        val output = getOutputForMatchupLogs(nonEmptyMatchupLogLists)
        output.lines().zip(nonEmptyMatchupLogLists).forEach { (outputLine, matchupLog) ->
            assertEquals(
                "${playerA.displayName}: ${matchupLog.playerAChoice.displayName} | ${playerB.displayName}: ${matchupLog.playerBChoice.displayName} | Result: ${matchupLog.matchupResult.displayName}",
                outputLine
            )
        }
    }
}
