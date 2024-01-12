package com.hartwigtest.ui;

import com.hartwigtest.model.MoveKind;

public interface UserInterface {
    MoveKind readMove(String playerName);

    void writeMessage(String message);

    // For future extension
    // GameOptions readGameOptions();
    // PlayerType readPlayerType(int number);
    // String readPlayerName(int number);
}