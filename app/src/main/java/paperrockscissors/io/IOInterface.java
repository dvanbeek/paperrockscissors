package paperrockscissors.io;

import paperrockscissors.Move;
import paperrockscissors.players.Player;

public interface IOInterface {
    Move promptNextMove(String playerName);
    void summarizeRound(Player player1, Player player2, Move move1, Move move2, String winner);
    boolean promptPlayAnotherRound();
    void announceRoundStart();
    void summarizeGame(Player player1, Player player2, int player1Wins, int player2Wins, int draws);
    String promptPlayerName();
}
