package unittests.paperrockscissors.players.factories;

import org.junit.jupiter.api.Test;
import paperrockscissors.players.ComputerPlayer;
import paperrockscissors.players.factories.ComputerPlayerBlueprint;
import paperrockscissors.players.factories.ComputerPlayerFactory;
import paperrockscissors.players.strategies.RandomStrategy;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerFactoryTest {

    @Test
    public void testRandomComputerPlayerGeneration() {
        String computerName = "computron";
        ComputerPlayerFactory factory = new ComputerPlayerFactory();
        ComputerPlayer computerPlayer = factory.create(ComputerPlayerBlueprint.RANDOM_COMPUTER_PLAYER, computerName);

        assertEquals(computerName, computerPlayer.getName());
        assertInstanceOf(RandomStrategy.class, computerPlayer.getStrategy());
    }

}
