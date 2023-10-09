package com.hartwig.rpc.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomMoveGeneratorTest {

    @Test
    void generateMove_shouldReturnMove() {
        RandomMoveGenerator randomMoveGenerator = new RandomMoveGenerator();
        assertNotNull(randomMoveGenerator.generateMove());
    }
}
