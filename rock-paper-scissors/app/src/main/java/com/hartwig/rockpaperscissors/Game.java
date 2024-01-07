package com.hartwig.rockpaperscissors;
//todo add new package games and move Game there

public interface Game {

    public String getDescription();
    public boolean userWantsToPlay() throws GameException;
    public void play() throws GameException;
    public void end();
}
