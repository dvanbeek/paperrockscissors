package com.hartwig.paperrockscissors;

import java.util.Scanner;

import com.hartwig.paperrockscissors.domain.Player;
import com.hartwig.paperrockscissors.domain.enums.Move;
import com.hartwig.paperrockscissors.domain.enums.Result;
import com.hartwig.paperrockscissors.service.PaperRockScissorsGameService;
import com.hartwig.paperrockscissors.utils.ParsingUtils;

import static java.lang.System.exit;

public class Main {
    private static final String COMPUTER_NAME = "Computer";
    private static final String DEFAULT_PLAYER_NAME = "Player";
    private static final String ESCAPE_COMMAND = "QUIT";
    private static final String INSTRUCTIONS = String.format(
            "Your available moves are %s, %s & %s (not case-sensitive).%n"
                    + "The game will conclude if you enter %s.%n",
            Move.ROCK, Move.PAPER, Move.SCISSORS, ESCAPE_COMMAND);

    public static void main(String[] args) {
        System.out.printf("Welcome to a game of rock paper scissors!%n"
                + "What's your name?%n");

        final Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine().trim();
        if (playerName.isBlank()) playerName = DEFAULT_PLAYER_NAME;

        final Player player = new Player(playerName);
        final Player computer = new Player(COMPUTER_NAME);

        System.out.printf("You're about to play rock paper scissors against %s.%n%s", computer.getName(), INSTRUCTIONS);
        final PaperRockScissorsGameService currentGame = new PaperRockScissorsGameService(player, computer);

        while (true) {
            System.out.println("Please enter your move...");
            final String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase(ESCAPE_COMMAND)) break;
            try {
                final Move playerMove = ParsingUtils.parseMoveFromInput(input);
                final Move computerMove = computer.playRandomMove();
                System.out.printf("%s played %s and %s played %s%n", player.getName(), playerMove, computer.getName(), computerMove);
                final Result playerResult = currentGame.determineResultForPlayerOne(playerMove, computerMove);
                System.out.printf("You %s!%n", playerResult.toString().toLowerCase());
            } catch (final IllegalArgumentException e) {
                System.out.printf("Invalid move. Please provide a valid move.%n%s", INSTRUCTIONS);
            }
        }
        player.printGameSummary();
        exit(0);
    }
}