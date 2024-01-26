package com.hartwig.paperrockscissors.engine;

import com.hartwig.paperrockscissors.exceptions.InvalidMoveException;
import com.hartwig.paperrockscissors.exceptions.QuitGameException;
import com.hartwig.paperrockscissors.model.Move;
import com.hartwig.paperrockscissors.model.Player;
import com.hartwig.paperrockscissors.model.RoundResult;
import com.hartwig.paperrockscissors.model.Rules;

/**
 * Game Engine for Paper Rock Scissors 
 *
 */
@SuppressWarnings("java:S106")
public class GameEngine {
	// Players
	private final Player player1;
  private final Player player2;
	// Scores
	private int totalMoves = 0;
	private int player1Wins = 0;
	private int player2Wins = 0;
	private int ties = 0;
	
	public GameEngine (Player player1, Player player2 ) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
 	* Main start method of game engine
	* Consists of a while loop that is exited upon receiving a QuitGameException from GameControls.
 	*/
	public void start() {
		final String DIVIDER_LINE = "-------------------------------";
		final String TIMES = " times.";

		System.out.println(DIVIDER_LINE);
		System.out.println("Welcome to Paper Rock Scissors");
		System.out.println("Please press p for paper, r for rock, s for scissors, or q to quit.");

		boolean continuePlaying = true;
		while (continuePlaying) {
			System.out.println(DIVIDER_LINE);
			try {
				// ------------------------------------------------
				// Human move 
				// ------------------------------------------------
				System.out.print("Enter your move: ");
				Move humanMove = player1.getMove();
				// When reaching this point no QuitGameException or InvalidMoveException has been thrown 
				// so we can assign the move of type Move 
				System.out.println("Your move: " + humanMove.toString());

				// ------------------------------------------------
				// Computer move 
				// ------------------------------------------------
				Move computerMove = player2.getMove();
				// When reaching this point no QuitGameException or InvalidMoveException has been thrown 
				// so we can assign the move of type Move 
				System.out.println("Computer move: " + computerMove.toString());
		
				// ------------------------------------------------
				// Determine and print result and update scores
				// ------------------------------------------------
				totalMoves ++;
				RoundResult result = Rules.evaluateMoves(humanMove, computerMove);
				switch (result) {
					case TIE:
						ties ++;
						System.out.println("It's a tie!");
						break;
					case PLAYER1_WINS:
						player1Wins++;
						System.out.println("You win!");
						break;
					case PLAYER2_WINS:
						player2Wins++;
						System.out.println("You lose!");
						break;
				}

			} catch (QuitGameException e) {
				// Player wants to quit, print results and exit session
				System.out.println(DIVIDER_LINE);
				System.out.println("In this session you have played " + totalMoves + TIMES);
				System.out.println("You won " + player1Wins + TIMES);
				System.out.println("You lost " + player2Wins + TIMES);
				System.out.println("There were " + ties + " ties.");
				System.out.println(DIVIDER_LINE);
				// Exit the while loop
				continuePlaying = false;

			} catch (InvalidMoveException e) {
				System.out.println("This move is invalid! Valid moves are r, p, s or q to quit.");
			}
		}
	}
}