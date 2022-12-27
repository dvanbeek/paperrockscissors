package nl.hartwigmedical;

import nl.hartwigmedical.game.Game;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting the game....hold on..");
        Game game = Game.initGame();
        game.askForHumanPlayerName(scanner);
        game.nextRound(scanner);
    }

}
