package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class GoFactoryTest {

    @Test
    void openHand_Rock_ReturnsRock() {
        var actual = GoFactory.openHand(Hand.Rock);
        assertInstanceOf(Rock.class, actual.get());
    }

    @Test
    void openHand_Paper_ReturnsPaper() {
        var actual = GoFactory.openHand(Hand.Paper);
        assertInstanceOf(Paper.class, actual.get());
    }

    @Test
    void openHand_Scissors_ReturnsScissors() {
        var actual = GoFactory.openHand(Hand.Scissors);
        assertInstanceOf(Scissors.class, actual.get());
    }

}