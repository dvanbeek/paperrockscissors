import java.io.InputStreamReader
import java.io.PrintStream

fun main(args: Array<String>) {
    val gui: Gui = CliGui(
        InputStreamReader(System.`in`),
        PrintStream(System.`out`, true)
    )
    runGame(Player.Human("Arie"), Player.Cpu(), gui)
}
