package keesfani.rps;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Game {
    OutcomeDecider decider;
    EnumMap<Outcome, Integer> scores;

    private Game(OutcomeDecider outcomeDecider) {
        this.decider = outcomeDecider;

        this.scores = new EnumMap<>(Outcome.class);
        for (Outcome outcome : Outcome.values()) {
            scores.put(outcome, 0);
        }
    }

    public void run() {
        System.out.println("Welcome to Kees' Rock Paper Scissors game!");
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            continueLoop = gameloop(scanner);
        }
        System.out.println("You have exited the game! Summary: " + createSummary(scores));
        System.exit(0);
    }

    private boolean gameloop(Scanner scanner) {
        System.out.print("Enter either 'rock', 'paper', 'scissors' or 'exit': ");
        String command = scanner.nextLine();

        if (command.equals("exit")) {
            return false;
        }

        Move humanMove = Move.fromString(command);
        if (humanMove != null) {
            incrementScore(decider.determineOutcome(humanMove, Move.randomMove()));
        } else {
            System.out.println("Invalid input: '" + command + "'");
        }

        return true;
    }

    private void incrementScore(Outcome outcome) {
        scores.put(outcome, scores.get(outcome) + 1);
    }

    String createSummary(EnumMap<Outcome, Integer> scores) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        scores.forEach((outcome, score) -> sb.append(outcome).append(": ").append(score).append(", "));
        sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }

    public static Game createStandardGame() {
        return new Game(new OutcomeDecider());
    }
}
