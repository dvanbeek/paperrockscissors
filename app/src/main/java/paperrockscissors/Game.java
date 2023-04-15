package paperrockscissors;

import paperrockscissors.io.IOInterface;
import paperrockscissors.players.Player;
import paperrockscissors.rules.Rules;

public class Game {

    private final Rules rules;
    private final Player player1;
    private final Player player2;
    private final IOInterface io;

    private int[] scoreboard = new int[3];

    public Game(IOInterface io, Rules rules, Player player1, Player player2) {
        this.io = io;
        this.rules = rules;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void nextRound() {
        io.announceRoundStart();
        Move move1 = player1.makeMove();
        Move move2 = player2.makeMove();
        int winnerI = rules.decideWinner(move1, move2);
        scoreboard[winnerI]++;
        String winnerString = winnerI == 0 ? null : (winnerI == 1 ? player1.getName() : player2.getName());
        io.summarizeRound(player1, player2, move1, move2, winnerString);
        if (io.promptPlayAnotherRound()) {
            nextRound();
        } else {
            endGame();
        }
    }

    public void endGame() {
        io.summarizeGame(player1, player2, scoreboard[1], scoreboard[2], scoreboard[0]);
    }
}
