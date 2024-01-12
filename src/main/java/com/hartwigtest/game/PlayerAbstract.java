package com.hartwigtest.game;

import com.hartwigtest.model.MoveKind;

abstract class PlayerAbstract {
    private String mName;

    public PlayerAbstract(String playerName) {
        mName = playerName;
    }

    public String name() {
        return mName;
    }

    abstract MoveKind move();
}
