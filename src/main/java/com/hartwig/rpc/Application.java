package com.hartwig.rpc;

import com.hartwig.rpc.game.Game;
import com.hartwig.rpc.game.MoveComparator;
import com.hartwig.rpc.game.RandomMoveGenerator;
import com.hartwig.rpc.ui.ConsoleUI;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new ConsoleUI(), new RandomMoveGenerator(), new MoveComparator());
        game.play();
    }
}
