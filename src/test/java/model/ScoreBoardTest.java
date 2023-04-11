package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    ScoreBoard scoreBoard;
    HumanPlayer humanPlayer;
    ComputerPlayer computerPlayer;

    @BeforeEach
    public void setup() {
        scoreBoard = new ScoreBoard();
        humanPlayer = new HumanPlayer("Hartwig");
        computerPlayer = new ComputerPlayer("Computer");
    }

    @Test
    public void addPlayersTest() {
        assertEquals(0, scoreBoard.getOrderedScoreList().size());
        scoreBoard.addPlayer(humanPlayer);
        scoreBoard.addPlayer(computerPlayer);
        assertEquals(2, scoreBoard.getOrderedScoreList().size());
    }

    @Test
    public void incrementScoreTest() {
        scoreBoard.addPlayer(humanPlayer);
        scoreBoard.incrementScore(humanPlayer);
        assertEquals(1, scoreBoard.getOrderedScoreList().stream().findFirst().get().score());
        scoreBoard.incrementScore(humanPlayer);
        assertEquals(2, scoreBoard.getOrderedScoreList().stream().findFirst().get().score());
    }

    @Test
    public void getOrderedScoreListTest() {
        scoreBoard.addPlayer(humanPlayer);
        scoreBoard.incrementScore(humanPlayer);
        scoreBoard.incrementScore(humanPlayer);
        scoreBoard.addPlayer(computerPlayer);

        ComputerPlayer otherComputerPlayer = new ComputerPlayer("Computer1");
        scoreBoard.incrementScore(otherComputerPlayer);

        assertEquals(humanPlayer, scoreBoard.getOrderedScoreList().get(0).player());
        assertEquals(otherComputerPlayer, scoreBoard.getOrderedScoreList().get(1).player());
        assertEquals(computerPlayer, scoreBoard.getOrderedScoreList().get(2).player());
    }


}
