package hartwig.interview.rps.input;

import hartwig.interview.rps.domain.rules.data.Hand;
import hartwig.interview.rps.input.data.InputHand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandDomainMapperTest {

    @Test
    void mapHandToDomain_InputRock_ReturnsRock() {
        var actual = HandDomainMapper.mapHandToDomain(InputHand.Rock);
        assertEquals(actual.get(), Hand.Rock);
    }

    @Test
    void mapHandToDomain_InputPaper_ReturnsPaper() {
        var actual = HandDomainMapper.mapHandToDomain(InputHand.Paper);
        assertEquals(actual.get(), Hand.Paper);
    }

    @Test
    void mapHandToDomain_InputScissors_ReturnsScissors() {
        var actual = HandDomainMapper.mapHandToDomain(InputHand.Scissors);
        assertEquals(actual.get(), Hand.Scissors);
    }
}