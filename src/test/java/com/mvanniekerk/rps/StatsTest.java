package com.mvanniekerk.rps;

import com.mvanniekerk.rps.match.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsTest {
    @Test
    void toStringTest() {
        var stats = new Stats();
        stats.addResult(Result.WIN);
        stats.addResult(Result.WIN);
        stats.addResult(Result.WIN);
        stats.addResult(Result.LOSS);
        stats.addResult(Result.LOSS);
        stats.addResult(Result.DRAW);

        var expected = """
           You won 3 times.
           You lost 2 times.
           You drew 1 times.
           """;

        assertEquals(expected, stats.toString());
    }
}