package hartwig.interview.rps.domain.rules;

import hartwig.interview.rps.RPSApplication;
import hartwig.interview.rps.domain.rules.data.HandResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RPSApplication.class, initializers = ConfigDataApplicationContextInitializer.class)
class RefereeTest {

    @Autowired
    Referee referee;
    @Test
    public void judge_RockPaper_returnsLoose(){
        OpenHand move1 = new Rock();
        OpenHand move2 = new Paper();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Loose, playerPerspectiveResult);

    }

    @Test
    public void judge_PaperRock_returnsWin(){
        OpenHand move1 = new Paper();
        OpenHand move2 = new Rock();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Win, playerPerspectiveResult);
    }

    @Test
    public void judge_PaperScissors_returnsLoose(){
        OpenHand move1 = new Paper();
        OpenHand move2 = new Scissors();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Loose, playerPerspectiveResult);
    }

    @Test
    public void judge_ScissorsPaper_returnsLoose(){
        OpenHand move1 = new Scissors();
        OpenHand move2 = new Paper();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Win, playerPerspectiveResult);
    }

    @Test
    public void judge_ScissorsRock_returnsLoose(){
        OpenHand move1 = new Scissors();
        OpenHand move2 = new Rock();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Loose, playerPerspectiveResult);
    }

    @Test
    public void judge_RockScissors_returnsLoose(){
        OpenHand move1 = new Rock();
        OpenHand move2 = new Scissors();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Win, playerPerspectiveResult);
    }

    @Test
    public void judge_RockRock_returnsLoose(){
        OpenHand move1 = new Rock();
        OpenHand move2 = new Rock();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Tie, playerPerspectiveResult);
    }
    @Test
    public void judge_ScissorsScissors_returnsLoose(){
        OpenHand move1 = new Scissors();
        OpenHand move2 = new Scissors();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Tie, playerPerspectiveResult);
    }
    @Test
    public void judge_PaperPaper_returnsLoose(){
        OpenHand move1 = new Paper();
        OpenHand move2 = new Paper();
        var playerPerspectiveResult = referee.judge(move1, move2);
        assertEquals(HandResult.Tie, playerPerspectiveResult);
    }
}