package com.hartwig.rockpaperscissors;

import com.hartwig.rockpaperscissors.cli.BooleanInputRetriever;
import com.hartwig.rockpaperscissors.cli.MoveInputRetriever;
import com.hartwig.rockpaperscissors.cli.ParseException;
import com.hartwig.rockpaperscissors.GameException;
import com.hartwig.rockpaperscissors.model.Move;
import com.hartwig.rockpaperscissors.evaluator.MoveEvaluator;
import java.util.List;
import java.util.ArrayList;


public class RockPaperScissors implements Game {

	BooleanInputRetriever booleanInputRetriever = new BooleanInputRetriever();
	MoveInputRetriever moveInputRetriever = new MoveInputRetriever();
	MoveEvaluator moveEvaluator = new MoveEvaluator();

	private List<Move> userMoves;
	private List<Move> computerMoves;

	public RockPaperScissors() {
		this.userMoves = new ArrayList();
		this.computerMoves = new ArrayList();
	}

	private List<Move> getUserMoves() {
		return this.userMoves;
	}

	private List<Move> getComputerMoves() {
		return this.computerMoves;
	}

    public String getDescription() {
        return "Welcome to Rock Paper Scissors.";
    }

    public boolean userWantsToPlay() throws GameException {
    	try {
    		return booleanInputRetriever.getBooleanInput("Would you like to play a game of Rock Paper Scissors against me?");
    	} catch(ParseException e) {
    		throw new GameException("Game does not understand user input check parser: " + e.getInput());
    	}
    }

    public void play() throws GameException {
    	Move winningMove = null;
    	while(winningMove == null) {
	    	try {
	    		Move userMove =  moveInputRetriever.getMove("What's your move?");
	    		userMoves.add(userMove);

	    		Move computerMove = Move.getRandom();
	    		computerMoves.add(computerMove);

	    		System.out.println("I choose " + computerMove.name());
	    		winningMove = moveEvaluator.getWinningMove(userMove, computerMove);

	    		if (winningMove == null) {
	    			System.out.println("A draw, let's go again!");
	    		}

	    	} catch(ParseException e) {
				throw new GameException("Game does not understand user input check parser: " + e.getInput());
	    	}
    	}

    	printOutcome(winningMove);

    }

    private void printOutcome(Move winningMove) {
	    System.out.println("It took us " + userMoves.size() + " rounds to get to a winner. Here is a summary of what happened.");
	    for (int i = 0; i <= userMoves.size() - 1 ; i++) {
	    	System.out.println("You played " + userMoves.get(i) + " and I played " + computerMoves.get(i));
	    }

	    Move finalUserMove = userMoves.get(userMoves.size() - 1);
	    if(winningMove == finalUserMove) {
	    	System.out.println("You won the final round using " + winningMove.name() + "\n");
	    } else {
	    	System.out.println("You lost the final round against " + winningMove.name() + "\n");
	    }
    }


    public void reset() {
		this.userMoves = new ArrayList();
		this.computerMoves = new ArrayList();
    }

    public void end() {
    	System.out.println("Bye");
    }

}
