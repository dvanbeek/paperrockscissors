package com.hartwigtest.game;

import com.hartwigtest.model.PlayerType;
import com.hartwigtest.ui.UserInterface;

final class PlayerFactory {
    static public PlayerAbstract createPlayer(PlayerType type, UserInterface userInterface) {
        switch (type) {
            case HUMAN:
                return new PlayerHuman(userInterface);

            case COMPUTER:
                return new PlayerComputer();

            default:
                return null;
        }
    }
}