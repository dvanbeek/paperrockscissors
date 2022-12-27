package nl.hartwigmedical.game;

import nl.hartwigmedical.exceptions.InvalidChoiceException;
import nl.hartwigmedical.exceptions.InvalidPlayerNameException;
import nl.hartwigmedical.exceptions.TooManyPLayersException;
import nl.hartwigmedical.players.ComputerPlayer;
import nl.hartwigmedical.players.HumanPlayer;
import nl.hartwigmedical.players.Player;
import org.javatuples.Pair;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static java.lang.String.format;


public class Game {

    static Game GAMEINSTANCE;
    //only 2 players allowed
    private final ArrayList players = new ArrayList();
    private Choice playerChoice;
    public Choice computerChoice;
    GameStrategy gameStrategy;
    int ties = 0;

    public Choice getPlayerChoice() {
        return playerChoice;
    }

    public Choice getComputerChoice() {
        return computerChoice;
    }

    public static Game initGame() throws TooManyPLayersException {
        if (GAMEINSTANCE == null) {
            GAMEINSTANCE = new Game();
            GAMEINSTANCE.gameStrategy = new SimpleGameStrategy();
            GAMEINSTANCE.addPlayer(new ComputerPlayer());
        }
        return GAMEINSTANCE;
    }

    public void addPlayer(Player player) throws TooManyPLayersException {
        if (players.size() > 1) {
            throw new TooManyPLayersException();
        }
        players.add(player);
    }

    public HumanPlayer getHumanPlayerFromGame() {
        return (HumanPlayer) players.get(1);
    }

    public void askForHumanPlayerName(Scanner scanner) throws TooManyPLayersException, InvalidPlayerNameException {
        System.out.println("Hi, whats your name: ");
        String name = scanner.nextLine();
        this.addPlayer(new HumanPlayer(name));
    }

    public ComputerPlayer getComputerPlayerFromGame() {
        return (ComputerPlayer) players.get(0);
    }

    public void askForHumanPlayerChoice(Scanner scanner) {
        String playerChoice = scanner.nextLine();
        try {
            this.playerChoice = Choice.valueOfLabel(playerChoice);
        } catch (InvalidChoiceException e) {
            System.out.println("Bad choice please choose again!");
            askForHumanPlayerChoice(scanner);
        }
    }

    public void askForComputerPlayerChoice() {
        this.computerChoice = gameStrategy.applyStrategy();
    }

    /**
     * Determine based on choice of each player which player wins
     * returns @Player
     */
    public BiFunction<Pair<Player, Choice>, Pair<Player, Choice>, Optional<Player>> determineWinner = (playerChoicePair, computerChoicePair) -> {
        if (playerChoicePair.getValue1().beats(computerChoicePair.getValue1())) {
            return Optional.of(playerChoicePair.getValue0());
        }

        if(computerChoicePair.getValue1().beats(playerChoicePair.getValue1())){
            return Optional.of(computerChoicePair.getValue0());
        }
        return Optional.empty();
    };

    /**
     * Show the human player choice
     */
    Consumer<String> getHumanPLayerChoice = choice -> System.out.println("The player choice is " + choice);


    Consumer<String> getComputerPLayerChoice = choice -> System.out.println("The computerplayer choice is " + choice);

    /**
     * Show the round winners name and increment total wins
     */
    Consumer<Player> showRoundWinner = player -> {
        player.incrementWins();
        System.out.println("The winner of this round is " + player.getName());
    };

    /**
     * Show the choices of the players
     */
    BiConsumer<Pair<Player, Choice>, Pair<Player, Choice>> showPlayerChoices = (playerChoicePair, computerChoicePair) -> {
        System.out.println(format("Your choice was: %s", playerChoicePair.getValue1().label));
        System.out.println(format("Your opponents choice was: %s", computerChoicePair.getValue1().label));
    };

    /**
     * Shows the welcome message of the game
     */
    BiConsumer<Player, Player> showWelcomeMessage = (humanPlayer, computerPlayer) -> System.out.println(format("Hi %s, welcome to rock, paper, scissors, you opponent is %s", humanPlayer.getName(), computerPlayer.getName()));


    /***
     * Show the round winner message
     */
    BiConsumer<Player, Player> showOverallWinner = (humanPlayer, computerPlayer) -> {
        System.out.println(format("Player %s has a total score of %s", humanPlayer.getName(), humanPlayer.getWins()));
        System.out.println(format("Player %s has a total score of %s", computerPlayer.getName(), computerPlayer.getWins()));
    };

    /***
     * Ask the player for input on choices which can be made
     */
    Consumer<String> showPlayerChoiceOptions = new Consumer<String>() {
        @Override
        public void accept(String name) {
            System.out.println(format("Ok %s,  pick your value (%s): ", name, format("Choice can only be of value %s", Choice.getLabels())));
        }
    };

    /***
     * Ask the player to continue
     * @param scanner
     */
    public void askToContinue(Scanner scanner) {
        System.out.println("Do you want to continue the game Y/N");
        String proceed = scanner.nextLine();
        if (proceed.equals("Y")) {
            nextRound(scanner);
        } else {
            showOverallWinner.accept(getHumanPlayerFromGame(), getComputerPlayerFromGame());
            showTies.accept(getTies());
            System.out.println(format("Bye Bye"));
        }
    }

    public void nextRound(Scanner scanner) {
        playerChoice = null;
        computerChoice = null;

        //show choice
        this.showPlayerChoiceOptions.accept(getHumanPlayerFromGame().getName());

        //ask for humanplayer choice
        this.askForHumanPlayerChoice(scanner);

        //ask for computer player choice
        this.askForComputerPlayerChoice();

        this.getComputerPLayerChoice
                .andThen(getComputerPLayerChoice);


        //construct player and choice
        Pair<Player, Choice> humanPlayerChoice = new Pair<>(getHumanPlayerFromGame(), getPlayerChoice());
        Pair<Player, Choice> computerPlayerChoice = new Pair<>(getComputerPlayerFromGame(), getComputerChoice());

        this.showPlayerChoices.accept(humanPlayerChoice, computerPlayerChoice);


        Optional<Player> winner = this.determineWinner.apply(humanPlayerChoice, computerPlayerChoice);

        if (winner.isEmpty()) {
            ties++;
            System.out.println("Its a tie!");
        } else {
            this.showRoundWinner.accept(winner.get());
        }

        this.askToContinue(scanner);

    }

    public int getTies() {
        return ties;
    }

    Consumer<Integer> showTies = ties -> System.out.println(format("The total number of ties is: %s", ties));

}
