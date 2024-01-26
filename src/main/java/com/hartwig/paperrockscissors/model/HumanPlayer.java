package com.hartwig.paperrockscissors.model;

import com.hartwig.paperrockscissors.engine.GameControls;

public class HumanPlayer implements PlayerInterface {
  private final GameControls gameControls;

  public HumanPlayer(GameControls gameControls) {
    this.gameControls = gameControls;
  }

  @Override
  public MoveEnum getMove() {
    return gameControls.getPlayerMove();
  }
}
