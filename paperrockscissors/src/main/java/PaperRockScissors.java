import computer.Computer;
import rules.Rules;
import score.Outcome;
import score.Player;
import shapes.Shape;

import java.util.Scanner;

public class PaperRockScissors {
    private final Player player;
    private final Computer computer;

    public PaperRockScissors(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void Play() {
        try (Scanner scanner = new Scanner(System.in)) {
            runGameLoop(scanner);
        } finally {
            player.printScore();
        }
    }

    public void runGameLoop(Scanner scanner) {
        String instructions = "Enter \"[p]aper\", \"[r]ock\" or \"[s]cissors\", press \"q\" to quit";
        System.out.println(instructions);

        String prs = scanner.nextLine();
        while (!prs.equals("q")) {
            Shape playerShape = Shape.getShape(prs);
            if (playerShape == null) {
                System.out.printf("wrong input \"%s\": %s%n", prs, instructions);
                prs = scanner.nextLine();
                continue;
            }
            Shape computerShape = computer.playRandomShape();
            Outcome outcome = Rules.playRound(playerShape, computerShape);
            System.out.printf("played %s against %s: %s%n", playerShape.name(), computerShape.name(), outcome.name());
            player.incrementScore(outcome);
            prs = scanner.nextLine();
        }
    }
}
