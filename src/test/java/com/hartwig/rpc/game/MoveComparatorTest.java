package com.hartwig.rpc.game;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveComparatorTest {

    private final MoveComparator moveComparator = new MoveComparator();

    @Test
    void compareMoves_shouldReturnWin_whenPlayerBeatsComputer() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.SCISSORS;

        Result result = moveComparator.compareMoves(playerMove, computerMove);

        assertEquals(Result.WIN, result);
    }

    @Test
    void compareMoves_shouldReturnLose_whenComputerBeatsPlayer() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.PAPER;

        Result result = moveComparator.compareMoves(playerMove, computerMove);

        assertEquals(Result.LOSE, result);
    }

    @Test
    void compareMoves_shouldReturnTie_whenMovesAreEqual() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.ROCK;

        Result result = moveComparator.compareMoves(playerMove, computerMove);

        assertEquals(Result.TIE, result);
    }
}

