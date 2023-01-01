package nl.mplb.domain;

import java.io.PrintWriter;
import java.util.Scanner;

/** This class is responsible for all communication with the user */
public class UserInterface {
  PrintWriter printWriter = new PrintWriter(System.out, true);
  Scanner scanner = new Scanner(System.in);

  public void showWelcomeMessage() {
    printWriter.println("Let's play some Rock Paper Scissors!");
  }

  public String promptMove() {
    return prompt("What is your move?");
  }

  public void showAvailableMoves() {
    printWriter.println("Please pick one of the following moves: R, Rock, P, Paper, S or Scissors");
  }

  public boolean promptStopPlaying() {
    String input = prompt("Do you want to exit? (y/n)");
    return "y".equalsIgnoreCase(input);
  }

  public void buildExcitementBeforeGame() {
    printWriter.println("Get ready!");
    sleep(500);
    for (int i = 3; i > 0; i--) {
      printWriter.println(i + "...");
      sleep(500);
    }
  }

  public void showGameResults(Moves humanMove, Moves computerMove, GameOutcome gameOutcome) {
    printWriter.println("You: " + humanMove);
    printWriter.println("Computer: " + computerMove);
    switch (gameOutcome) {
      case WIN:
        printWriter.println("You have won!");
        break;
      case LOSE:
        printWriter.println("You lost");
        break;
      case TIE:
        printWriter.println("It's a tie");
        break;
    }
  }

  public void showGameEndSummary(long wins, long loses, long ties) {
    printWriter.println("Thank you for playing!");
    printWriter.println("Your score:");
    printWriter.println("Won: " + wins);
    printWriter.println("Lost: " + loses);
    printWriter.println("Tied: " + ties);
  }

  private String prompt(String prompt) {
    printWriter.println(prompt);
    return scanner.nextLine().strip();
  }

  private void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      System.err.println("Interrupted error: " + e);
      Thread.currentThread().interrupt();
    }
  }
}
