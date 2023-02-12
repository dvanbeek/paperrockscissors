package com.hartwig.paperrockscissors.technical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hartwig.paperrockscissors.domain.Choice;
import com.hartwig.paperrockscissors.domain.Move;
import com.hartwig.paperrockscissors.domain.Player;
import com.hartwig.paperrockscissors.domain.RockPaperScissors;
import com.hartwig.paperrockscissors.domain.Round;
import com.hartwig.paperrockscissors.domain.Score;
import com.hartwig.paperrockscissors.domain.TwoPlayerGame;

import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.hartwig.paperrockscissors.domain.Choice.UNKNOWN;
import static java.util.List.of;

public class Main {

    private static final String QUIT_KEYWORD = "QUIT";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Let's play Rock, Paper, Scissors!");

        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");

        String playerName = input.nextLine().trim().toUpperCase();

        Player playerOne = new Player(playerName);
        Player computer = new Player("computer");

        RockPaperScissors game = new TwoPlayerGame();

        System.out.printf("Enter one of the following options: %s, or type Quit to stop and see the results%n", formatChoices(game.fetchPossibleChoice()));

        while (true) {
            System.out.println("Enter your choice: ");
            String playerInput = input.nextLine().trim();

            if (QUIT_KEYWORD.equalsIgnoreCase(playerInput)) {
                Score score = game.determineScore();
                System.out.printf("The results are conclusive: %s %n", new ObjectMapper().writeValueAsString(score));
                break;
            }

            Choice playerChoice = Choice.fromString(playerInput);
            if (playerChoice == UNKNOWN){
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            Choice computerChoice = randomChoice(game.fetchPossibleChoice());

            game.playRound(new Round(of(new Move(playerOne, playerChoice), new Move(computer, computerChoice))));

            System.out.printf("You played %s and the computer played %s.%n", playerChoice, computerChoice);
            System.out.println("Ready for the next round?");
        }
    }

    private static Choice randomChoice(EnumSet<Choice> choices) {
        return choices.toArray(new Choice[0])[RANDOM.nextInt(choices.size())];
    }

    private static String formatChoices(EnumSet<Choice> choices) {
        return choices.stream()
            .map(Enum::name)
            .collect(Collectors.joining(", "));
    }
}
