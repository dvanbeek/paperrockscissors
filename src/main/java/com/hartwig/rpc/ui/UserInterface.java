package com.hartwig.rpc.ui;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;

public interface UserInterface {
    String getUserMove();
    void displayComputerMove(Move move);
    void displayResult(Result result);
    void displayInvalidMoveMessage();
    void displayResults(int wins, int losses, int ties);
}

