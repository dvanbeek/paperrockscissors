package com.hartwig.paperrockscissors.service.interfaces;

import com.hartwig.paperrockscissors.domain.enums.Move;
import com.hartwig.paperrockscissors.domain.enums.Result;

public interface PaperRockScissorsGame {
    /**
     * Determines the result from the perspective of playerOne (first parameter).
     *
     * @param playerOneMove chosen Move of playerOne(self)
     * @param playerTwoMove chosen Move of playerTwo(opponent)
     * @return The Result for player one
     */
    Result determineResultForPlayerOne(Move playerOneMove, Move playerTwoMove);
}
