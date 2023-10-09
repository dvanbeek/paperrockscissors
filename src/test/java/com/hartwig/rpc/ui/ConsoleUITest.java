package com.hartwig.rpc.ui;

import com.hartwig.rpc.datamodel.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ConsoleUI consoleUI = new ConsoleUI();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void displayResult_shouldPrintWinMessage() {
        consoleUI.displayResult(Result.WIN);
        assertEquals("You win!\n", outContent.toString());
    }

    @Test
    void displayResult_shouldPrintLoseMessage() {
        consoleUI.displayResult(Result.LOSE);
        assertEquals("You lose!\n", outContent.toString());
    }

    @Test
    void displayResult_shouldPrintTieMessage() {
        consoleUI.displayResult(Result.TIE);
        assertEquals("It's a tie!\n", outContent.toString());
    }
}
