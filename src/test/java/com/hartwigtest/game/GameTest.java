package com.hartwigtest.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hartwigtest.model.GameOptions;
import com.hartwigtest.model.GameResults;
import com.hartwigtest.ui.UiFactory;
import com.hartwigtest.ui.UserInterface;

public class GameTest {
    private static final String kTestInputFileName = "com/hartwigtest/game/testData";
    private final UserInterface userInterface = UiFactory.creatUserInterface((getClass().getClassLoader().getResource(kTestInputFileName).getPath()));

    @Test
    public void testInputIsReadCorrectly() {
        final int kLostExpected = 1;
        final int kWonExpected = 1;
        final int kTiedExpected = 3;
        GameOptions gameOptions = new GameOptions();
        gameOptions.areAllHumans = true;
        Game game = new Game(gameOptions, userInterface);
        GameResults gameResults = game.play();
        assertEquals(kLostExpected, gameResults.lost);
        assertEquals(kWonExpected, gameResults.won);
        assertEquals(kTiedExpected, gameResults.tied);
    }   
}
