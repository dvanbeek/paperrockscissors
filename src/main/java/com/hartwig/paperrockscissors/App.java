package com.hartwig.paperrockscissors;

import java.util.Scanner;

import com.hartwig.paperrockscissors.engine.GameControls;
import com.hartwig.paperrockscissors.engine.GameEngine;
import com.hartwig.paperrockscissors.model.ComputerPlayer;
import com.hartwig.paperrockscissors.model.HumanPlayer;
import com.hartwig.paperrockscissors.model.Player;

public class App {
  
  public static void main(String[] args) {
    // Instantiate scanner
    Scanner scanner = new Scanner(System.in);
    // Instantiate game controls and inject scanner
    GameControls gameControls = new GameControls(scanner);

    // ShutdownHook to make sure the close method of gameControls is called when ctrl-c is pressed
    Runtime.getRuntime().addShutdownHook(new Thread(gameControls::close));

    // Instantiate human player and inject game controls
    Player humanPlayer = new HumanPlayer(gameControls);
    // Instatiate computer player
    Player computerPlayer = new ComputerPlayer();
    // Instantiate game engine and injecting the two players
    GameEngine game = new GameEngine(humanPlayer, computerPlayer);
    game.start();
  }

}
