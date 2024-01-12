package com.hartwigtest.ui;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hartwigtest.model.MoveKind;

public class CommandLineTest {
    private static final String kTestInputFileName = "com/hartwigtest/ui/testData";
    private final CommandLine cl = new CommandLine(getClass().getClassLoader().getResource(kTestInputFileName).getPath());

    @Test
    public void testInputIsReadCorrectly() {
        final String kTestName = "TEST";
        assertTrue(MoveKind.ROCK == cl.readMove(kTestName));
        assertTrue(MoveKind.PAPER == cl.readMove(kTestName));
        assertTrue(MoveKind.SCISSORS == cl.readMove(kTestName));
        assertNull(cl.readMove(kTestName));
    }
}