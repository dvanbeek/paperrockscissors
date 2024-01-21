import nl.app.rps.RockPaperScissors;
import nl.app.rps.models.ScoreBoard;
import nl.app.rps.players.Computer;
import nl.app.rps.players.Human;
import nl.app.rps.printers.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
       new RockPaperScissors(new Human(), new Computer(), new ConsolePrinter(), new ScoreBoard());
    }
}