package unittests.paperrockscissors.players;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import paperrockscissors.Move;
import paperrockscissors.io.IOInterface;
import paperrockscissors.players.HumanPlayer;
import paperrockscissors.players.Player;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class HumanPlayerTest {

    @Test
    public void testMakeMove() {
        IOInterface mockCli = mock(IOInterface.class);
        Move dummyMove = Move.ROCK;
        when(mockCli.promptNextMove("Foo")).thenReturn(dummyMove);
        Player player = new HumanPlayer("Foo", mockCli);

        Move move = player.makeMove();

        assertSame(move, dummyMove);
        verify(mockCli, Mockito.times(1)).promptNextMove("Foo");
    }

}
