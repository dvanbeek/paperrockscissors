package com.hartwigtest.game;

import com.hartwigtest.model.GameOptions;
import com.hartwigtest.model.GameResults;
import com.hartwigtest.model.MoveKind;
import com.hartwigtest.model.PlayerType;
import com.hartwigtest.ui.UserInterface;

public class Game {
    private GameOptions mGameOptions;
    private UserInterface mUserInterface;
    private PlayerAbstract[] players;
    private boolean mIsValid;
    private GameResults mGameResults;

    public Game(GameOptions gameOptions, UserInterface userInterface) {
        mGameOptions = gameOptions;
        mUserInterface = userInterface;
        mGameResults = new GameResults();
        mIsValid = mGameOptions.playersNumber > 1;
        if (!mIsValid) {
            mUserInterface.writeMessage("More than 1 players required to play the game.");
            return;
        }
        players = new PlayerAbstract[mGameOptions.playersNumber];
        // The first player is human, other are computers
        players[0] = PlayerFactory.createPlayer(PlayerType.HUMAN, userInterface);
        mIsValid &= mGameOptions.playersNumber > 1 && players[0] != null;
        PlayerType opponentType = mGameOptions.areAllHumans ? PlayerType.HUMAN : PlayerType.COMPUTER;
        for (int i = 1; i < players.length; ++i) {
            players[i] = PlayerFactory.createPlayer(opponentType, userInterface);
            mIsValid &= players[i] != null;
        }
    };

    public GameResults play() {
        if (!mIsValid) {
            mUserInterface.writeMessage(
                    "Unfortunately, one or more players hasn't been prepared for the game correctly... Can't play...");
            return null;
        }
        // At the moment supporting only one option of the game: user vs computer, but
        // future extension is possible.
        MoveKind hMove;
        MoveKind cMove;
        do {
            hMove = players[0].move();
            if (hMove != null) {
                cMove = players[1].move();
                mUserInterface.writeMessage(hMove.toString() + " - " + cMove.toString());
                if (hMove == cMove) {
                    mGameResults.tied++;
                } else if (hMove.isStrongerThan(cMove)) {
                    mGameResults.won++;
                } else {
                    mGameResults.lost++;
                }
            }
        } while (hMove != null);
        return mGameResults;
    }
};