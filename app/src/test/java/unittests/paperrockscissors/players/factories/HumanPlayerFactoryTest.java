package unittests.paperrockscissors.players.factories;

import org.junit.jupiter.api.Test;
import paperrockscissors.io.IOInterface;
import paperrockscissors.players.HumanPlayer;
import paperrockscissors.players.factories.HumanPlayerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HumanPlayerFactoryTest {


    @Test
    public void testCorrectInitialisation() {
        String playerName = "Foo";
        IOInterface mockIO = mock(IOInterface.class);
        when(mockIO.promptPlayerName()).thenReturn(playerName);

        HumanPlayerFactory factory = new HumanPlayerFactory(mockIO);
        HumanPlayer player = factory.create();

        assertEquals(playerName, player.getName());
    }
}
