package com.hartwig.rockpaperscissors;
//todo add new package games and move app there
import com.hartwig.rockpaperscissors.RockPaperScissors;
import com.hartwig.rockpaperscissors.GameException;
import java.util.*;

public class App {


    public static void main(String[] args) {

    	RockPaperScissors game = new RockPaperScissors();

    	try { 
	    	System.out.println(game.getDescription());
    		// todo keep track of games played and print summary
	  		while (game.userWantsToPlay()) {
	  			game.reset();
	    		game.play();
	  		}
	  		game.end();
  		} catch(GameException e) {
  			System.out.println("Something went wrong, exiting game");
  			System.out.println(e);
  		}

    }

}
