package nl.app.rps.printers;


import nl.app.rps.models.GamePrinter;
import nl.app.rps.models.GameResult;

public class ConsolePrinter implements GamePrinter {
    @Override
    public void intro() {
        System.out.println("Welcome to Rock-Paper-Scissors.");
        System.out.println("Input parameters are [r]ock, [p]aper, [s]cissors, to exit the game press e.");
    }

    @Override
    public void score(int loss, int draw, int win) {
        System.out.println("Final score:");
        System.out.printf("LOSS [%d], DRAW [%d], WIN [%d]%n", loss, draw, win);
    }

    @Override
    public void printResult(GameResult gameResult, String player1Input, String player2Input) {
        switch (gameResult) {
            case LOSS -> System.out.printf("LOSE! %s beats %s%n", player1Input, player2Input);
            case DRAW -> System.out.println("DRAW! you both selected "+ player1Input);
            case WIN -> System.out.printf("WIN! %s beats %s%n", player1Input, player2Input);
        }
    }
}
