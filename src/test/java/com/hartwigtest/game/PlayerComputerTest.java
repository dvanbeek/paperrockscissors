package com.hartwigtest.game;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

import com.hartwigtest.model.MoveKind;

public class PlayerComputerTest {
    PlayerComputer testComputerPlayer = new PlayerComputer();

    @Test
    public void testComputerGeneratesRandomMoves() {
        int kMaxIterationsToGetAllMoves = 30;
        Set<MoveKind> moveKinds = new TreeSet<MoveKind>();
        for (int i = 0; i < kMaxIterationsToGetAllMoves; ++i) {
            moveKinds.add(testComputerPlayer.move());
            if (moveKinds.size() == MoveKind.values().length) {
                break;
            }
        }
        assertEquals(MoveKind.values().length, moveKinds.size());
    }
}
