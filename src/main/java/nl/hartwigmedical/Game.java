package nl.hartwigmedical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    static Game game ;
    //only 2 players allowed
    private List<Player> players = new ArrayList();
    public static Game initGame() throws TooManyPLayersException {
        if (game == null){
            game = new Game();
            game.addPlayer(new ComputerPlayer());
        }
        return game;
    }

    public void addPlayer(Player player) throws TooManyPLayersException {
        if (this.players.size() > 1){
            throw new TooManyPLayersException();
        }
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public HumanPlayer getHumanPlayerFromGame(){
        return (HumanPlayer)players.get(1);
    }

    public void askForHumanPlayerName(Scanner scanner) throws TooManyPLayersException {
        String name = scanner.nextLine();
        this.addPlayer(new HumanPlayer(name));
    }
}
