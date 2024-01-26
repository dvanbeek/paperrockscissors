package com.hartwig.paperrockscissors.model;

import com.hartwig.paperrockscissors.engine.GameControls;

/**
* Implements Player Interface: getMove() uses GameControls to identify move.
*
*/
public class HumanPlayer implements Player {
  private final GameControls gameControls;

  public HumanPlayer(GameControls gameControls) {
    this.gameControls = gameControls;
  }

  @Override
  public Move getMove() {
    return gameControls.getPlayerMove();
  }
}
