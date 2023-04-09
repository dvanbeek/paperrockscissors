package games.rockpaperscissors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import games.IChoice;
import games.IGame;
import games.IPlayer;
import games.ResultsEnum;

public class RockPaperScissors implements IGame{
    
    private final List<IPlayer> players;
    private final List<IChoice> choices;
    private final ResultsEnum[][] rules;

    /**
     * Creates an new game of RockPaperScissors. The winner is decided from
     * the perspective of the first player.
     * 
     * @param players: The players to participate (max. 2 players)
     */
    public RockPaperScissors(List<IPlayer> players)
    {
        this.players = players;
        this.choices = Arrays.asList(RockPaperScissorsOptions.values());
        this.rules = getRules();
}

    private ResultsEnum[][] getRules() {
        ResultsEnum[][] rules = new ResultsEnum[this.choices.size()][this.choices.size()];
        rules[RockPaperScissorsOptions.ROCK.ordinal()][RockPaperScissorsOptions.SCISSORS.ordinal()] = ResultsEnum.WIN;
        rules[RockPaperScissorsOptions.ROCK.ordinal()][RockPaperScissorsOptions.PAPER.ordinal()] = ResultsEnum.LOSS;
        rules[RockPaperScissorsOptions.ROCK.ordinal()][RockPaperScissorsOptions.ROCK.ordinal()] = ResultsEnum.TIE;
        rules[RockPaperScissorsOptions.PAPER.ordinal()][RockPaperScissorsOptions.PAPER.ordinal()] = ResultsEnum.TIE;
        rules[RockPaperScissorsOptions.PAPER.ordinal()][RockPaperScissorsOptions.ROCK.ordinal()] = ResultsEnum.WIN;
        rules[RockPaperScissorsOptions.PAPER.ordinal()][RockPaperScissorsOptions.SCISSORS.ordinal()] = ResultsEnum.LOSS;
        rules[RockPaperScissorsOptions.SCISSORS.ordinal()][RockPaperScissorsOptions.PAPER.ordinal()] = ResultsEnum.WIN;
        rules[RockPaperScissorsOptions.SCISSORS.ordinal()][RockPaperScissorsOptions.ROCK.ordinal()] = ResultsEnum.LOSS;
        rules[RockPaperScissorsOptions.SCISSORS.ordinal()][RockPaperScissorsOptions.SCISSORS.ordinal()] = ResultsEnum.TIE;
        return rules;
    }

    /**
     * Plays a round of Rock, Paper, Scissors.
     * @param outputChoices: Print the player choices
     * Returns whether the first player won, tied or lost
     */
    public ResultsEnum play()
    {
        List<RockPaperScissorsOptions> chosenOptions = new ArrayList<>();
        int playerIndex = 0;
        for (IPlayer player : players) {
            RockPaperScissorsOptions choice = (RockPaperScissorsOptions) player.choose(this.choices);
            System.out.println("Player " + playerIndex + " chose " + choice.name());
            chosenOptions.add(choice);
            playerIndex++;
        }
        return rules[chosenOptions.get(0).ordinal()][chosenOptions.get(1).ordinal()];
    }

    /**
     * Prints the options to standard out.
     */
    public void displayOptions(){
        for (RockPaperScissorsOptions options : RockPaperScissorsOptions.values()) {
            System.out.println(options.ordinal() + ": " + options.name());
        }
    }
}
