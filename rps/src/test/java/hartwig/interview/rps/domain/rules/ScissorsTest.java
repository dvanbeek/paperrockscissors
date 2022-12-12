package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.HandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScissorsTest {

    @Test
    void rock() {
        assertEquals(new Scissors().againstRock(), HandResult.Loose);
    }

    @Test
    void paper() {
        assertEquals(new Scissors().againstPaper(),HandResult.Win);
    }

    @Test
    void scissors() {
        assertEquals(new Scissors().againstScissors(),HandResult.Tie);
    }
}