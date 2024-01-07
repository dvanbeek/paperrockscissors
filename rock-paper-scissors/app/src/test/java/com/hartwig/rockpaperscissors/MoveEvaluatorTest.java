package com.hartwig.rockpaperscissors;

import org.junit.Test;
import static org.junit.Assert.*;
import com.hartwig.rockpaperscissors.evaluator.MoveEvaluator;
import com.hartwig.rockpaperscissors.model.Move;

public class MoveEvaluatorTest {
    @Test 
    public void evaluationWorksCorrectly() {
        MoveEvaluator moveEvaluator = new MoveEvaluator();
        assertEquals(Move.Rock, moveEvaluator.getWinningMove(Move.Scissors, Move.Rock));
        assertEquals(Move.Rock, moveEvaluator.getWinningMove(Move.Rock, Move.Scissors));
        assertEquals(Move.Paper, moveEvaluator.getWinningMove(Move.Paper, Move.Rock));
        assertEquals(Move.Paper, moveEvaluator.getWinningMove(Move.Rock, Move.Paper));
        assertEquals(Move.Scissors, moveEvaluator.getWinningMove(Move.Scissors, Move.Paper));
        assertEquals(Move.Scissors, moveEvaluator.getWinningMove(Move.Paper, Move.Scissors));
    }
}
