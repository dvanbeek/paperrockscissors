package games;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import games.inputs.RandomInput;
import games.inputs.UserInput;
import games.players.Computer;
import games.players.Human;
import games.rockpaperscissors.*;

public class Main {

    private static boolean humanInGame = false;
    public static void main(String[] args) {

        // Initialize dependencies
        UserInput input = new UserInput();

        // Initialize players
        List<IPlayer> players = Arrays.asList(
            new Human(input),
            new Computer(new RandomInput())
        );
        
        for (IPlayer iPlayer : players) {
            if (iPlayer.isHuman()){
                humanInGame = true;
            }
        }

        // Store the results so the statistics can be 
        // shown after a player decides to stop playing.
        EnumMap<ResultsEnum, Integer> results = new EnumMap<>(ResultsEnum.class);
        results.put(ResultsEnum.WIN, 0);
        results.put(ResultsEnum.TIE, 0);
        results.put(ResultsEnum.LOSS, 0);

        // Initialize Game
        IGame game = new RockPaperScissors(players);
        // These are the input options for the user to play a new game or not.
        List<IChoice> inputOptions = Arrays.asList(GameInputOptions.values());

        // Play the game until the user decides to stop
        while (true) {
            displayOptions();
            GameInputOptions playGame = (GameInputOptions) input.choose(inputOptions);
            if (playGame == GameInputOptions.STOP)
            {
                break;
            }
            if (humanInGame) {
                game.displayOptions();
            }

            ResultsEnum result = game.play();
            System.out.println("Game was a " + result.name());
            results.put(result, results.get(result)  + 1);
        }

        input.close();

        System.out.println("\nGame Statistics:");
        System.out.println("Total games won : " + results.get(ResultsEnum.WIN));
        System.out.println("Total games tied: " + results.get(ResultsEnum.TIE));
        System.out.println("Total games lost: " + results.get(ResultsEnum.LOSS));
    }

    /**
     * Prints the input options for a user (play a game or stop)
     */
    public static void displayOptions(){
        for (GameInputOptions options : GameInputOptions.values()) {
            System.out.println(options.ordinal() + ": " + options.name());
        }
    }
}
