package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.HandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockTest {

    @Test
    void rock() {
        assertEquals(new Rock().againstRock(), HandResult.Tie);
    }

    @Test
    void paper() {
        assertEquals(new Rock().againstPaper(),HandResult.Loose);
    }

    @Test
    void scissors() {
        assertEquals(new Rock().againstScissors(),HandResult.Win);
    }
}