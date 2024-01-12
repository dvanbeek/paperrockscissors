package com.hartwigtest.app;

import com.hartwigtest.game.Game;
import com.hartwigtest.model.GameOptions;
import com.hartwigtest.model.GameResults;
import com.hartwigtest.ui.UiFactory;
import com.hartwigtest.ui.UserInterface;

public class App {
    public static void main(String[] args) {
        // Using default game options and default user interface
        // In future game configuration can be extended and another user interface added
        UserInterface userInterface = UiFactory.creatUserInterface();
        GameOptions gameOptions = new GameOptions();
        Game game = new Game(gameOptions, userInterface);
        GameResults gameResults = game.play();
        userInterface.writeMessage("Your results are:\nWON = " + Integer.toString(gameResults.won) + "\nTIED = "
                + Integer.toString(gameResults.tied) + "\nLOST = " + Integer.toString(gameResults.lost));
    };
};
