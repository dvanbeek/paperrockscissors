package com.hartwig.paperrockscissors.domain;

import java.util.EnumSet;

public interface RockPaperScissors {

    EnumSet<Choice> fetchPossibleChoice();

    void playRound(Round round);

    Score determineScore();
}
