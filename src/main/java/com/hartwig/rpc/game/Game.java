package com.hartwig.rpc.game;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;
import com.hartwig.rpc.ui.UserInterface;

public class Game {
    private final UserInterface ui;
    private final MoveGenerator moveGenerator;
    private final MoveComparator moveComparator;
    private int wins, losses, ties;

    public Game(UserInterface ui, MoveGenerator moveGenerator, MoveComparator moveComparator) {
        this.ui = ui;
        this.moveGenerator = moveGenerator;
        this.moveComparator = moveComparator;
    }

    public void play() {
        while (true) {
            var userMove = ui.getUserMove();
            if (userMove.equalsIgnoreCase("exit")) {
                ui.displayResults(wins, losses, ties);
                break;
            }

            Move playerMove;
            try {
                playerMove = Move.valueOf(userMove.toUpperCase());
            } catch (IllegalArgumentException e) {
                ui.displayInvalidMoveMessage();
                continue;
            }

            var computerMove = moveGenerator.generateMove();
            ui.displayComputerMove(computerMove);

            var result = moveComparator.compareMoves(playerMove, computerMove);
            ui.displayResult(result);

            updateScores(result);
        }
    }

    private void updateScores(Result result) {
        switch (result) {
            case WIN -> wins++;
            case LOSE -> losses++;
            case TIE -> ties++;
        }
    }
}

