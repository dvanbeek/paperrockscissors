package com.hartwigtest.game;

import com.hartwigtest.model.MoveKind;
import com.hartwigtest.ui.UserInterface;

final class PlayerHuman extends PlayerAbstract {
    static final String kDefaultHumanName = "YOU";
    private UserInterface mUserInterface;

    public PlayerHuman(UserInterface userInterface) {
        super(kDefaultHumanName);
        mUserInterface = userInterface;
    }

    public PlayerHuman(String name, UserInterface userInterface) {
        super(name);
        mUserInterface = userInterface;
    }

    @Override
    public MoveKind move() {
        return mUserInterface.readMove(name());
    }
};
