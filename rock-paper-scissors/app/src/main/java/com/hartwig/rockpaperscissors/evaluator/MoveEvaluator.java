package com.hartwig.rockpaperscissors.evaluator;

import com.hartwig.rockpaperscissors.model.Move;

public class MoveEvaluator {

	public Move getWinningMove(Move moveA, Move moveB) {
		if (moveA == moveB) {
			return null;
		}

		boolean aWins = false;
		switch(moveA) {
			case Rock:
				aWins = moveB == Move.Scissors;
				break;
			case Paper:
				aWins = moveB == Move.Rock;
				break;
			case Scissors:
				aWins = moveB == Move.Paper;
				break;
		}
		if (aWins) {
			return moveA;
		}
		return moveB;
	}

}
