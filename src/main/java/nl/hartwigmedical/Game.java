package nl.hartwigmedical;

public class Game {

    static Game game ;
    public static Game initGame(){
        if (game == null){
            game = new Game();
        }
        return game;
    }

}
