package com.hartwig.rpc.game;

import com.hartwig.rpc.datamodel.Move;
import com.hartwig.rpc.datamodel.Result;
import com.hartwig.rpc.ui.UserInterface;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @ParameterizedTest
    @EnumSource(Move.class)
    void play_shouldProduceCorrectOutcome_givenUserMove(Move userMove) {
        for (Move computerMove : Move.values()) {
            UserInterface ui = mock(UserInterface.class);
            when(ui.getUserMove()).thenReturn(userMove.name(), "exit");

            MoveGenerator moveGenerator = mock(MoveGenerator.class);
            when(moveGenerator.generateMove()).thenReturn(computerMove);

            Game game = new Game(ui, moveGenerator, new MoveComparator());
            game.play();

            Result expectedResult = new MoveComparator().compareMoves(userMove, computerMove);

            verify(ui).displayResult(expectedResult);
        }
    }
}
