package hartwig.interview.rps.domain.scores.model;

import hartwig.interview.rps.domain.rules.data.HandResult;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Value
@Component
@NoArgsConstructor
public class GameScore {
    private Map<String, PlayerScore> playerScore = new HashMap<>();

    public GameScore(String player1, String player2){
        playerScore.put(player1, new PlayerScore(0,0,0));
        playerScore.put(player2, new PlayerScore(0,0,0));
    }

    public PlayerScore getPlayerScore(String player){
        return playerScore.get(player);
    }
    public void recordScore(HandResult roundResult, String player1, String player2){
        if(roundResult == HandResult.Win)
            recordPlayer1Win(player1, player2);
        else if(roundResult == HandResult.Loose)
            recordPlayer1Loss(player1, player2);
        else if(roundResult == HandResult.Tie)
            recordTie(player1, player2);
    }

    private void recordTie(String player1, String player2) {
        playerScore.get(player1).recordTie();
        playerScore.get(player2).recordTie();
    }
    private void recordPlayer1Loss(String player1, String player2) {
        playerScore.get(player1).recordLoss();
        playerScore.get(player2).recordWin();
    }

    private void recordPlayer1Win(String player1, String player2) {
        playerScore.get(player1).recordWin();
        playerScore.get(player2).recordLoss();
    }
}
