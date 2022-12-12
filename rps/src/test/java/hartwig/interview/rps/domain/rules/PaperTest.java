package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.domain.rules.data.HandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PaperTest {

    @Test
    void rock() {
       assertEquals(new Paper().againstRock(), HandResult.Win);
    }

    @Test
    void paper() {
        assertEquals(new Paper().againstPaper(),HandResult.Tie);
    }

    @Test
    void scissors() {
        assertEquals(new Paper().againstScissors(),HandResult.Loose);
    }
}