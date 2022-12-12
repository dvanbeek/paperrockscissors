package hartwig.interview.rps.input;

import hartwig.interview.rps.domain.ports.Player;
import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.input.adapters.ComputerPlayer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerPlayerTest {
    @Test
    void playHand_AlwaysPlayesAllowedHand() {
        Player player = new ComputerPlayer();
        var acutal = player.playHand();
        assertThat(acutal.getCurrentHand()).isIn(Hand.Paper, Hand.Rock, Hand.Scissors);
    }
}