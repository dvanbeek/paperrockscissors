import com.hmf.Computer
import com.hmf.Game
import com.hmf.StdOutOutputter

fun main(args: Array<String>) {
    val opponent = Computer()
    val outputter = StdOutOutputter()
    val game = Game<Computer,StdOutOutputter>(opponent, outputter)
    game.play()
}