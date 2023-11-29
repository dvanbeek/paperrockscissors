package org.prs;

import java.util.Scanner;

/**
 * Runs the epic paper-rock-scissors game between man and machine.
 */
public class Game implements UserInputReader {
    private int computerScore;
    private int humanScore;
    private int totalRounds;

    public void start() {
        help();
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            var input = scanner.next();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }

            processInput(input);
        }
        printScore();
    }

    void computeScore(PaperRockScissors computer, PaperRockScissors human) {
        var score = computer.throwAgainst(human);
        if (score == -1) {
            humanScore++;
            System.out.println("YOU WIN!");
        } else if (score == 0) {
            System.out.println("DRAW!");
        } else {
            computerScore++;
            System.out.println("COMPUTER WINS!");
        }
        totalRounds++;
    }

    void processInput(String input) {
        readInput(input).ifPresentOrElse((human) -> {
            var computer = PaperRockScissors.draw();
            System.out.printf("Computer draws: %s%n", computer);
            computeScore(computer, human);
        }, this::help);
    }

    int getComputerScore() {
        return computerScore;
    }

    int getHumanScore() {
        return humanScore;
    }

    private void printScore() {
        System.out.printf("Total rounds %s%n", totalRounds);
        System.out.printf("Total draws %s%n", totalRounds - (humanScore + computerScore));
        System.out.printf("Final score Man %s v.s. Computer %s%n", humanScore, computerScore);
    }

    private void help() {
        System.out.println("Enter one of the 3 shapes (case insensitive): (P)APER, (R)OCK or (S)CISSORS");
        System.out.println("Enter 'q' or 'Q' to stop");
    }
}
