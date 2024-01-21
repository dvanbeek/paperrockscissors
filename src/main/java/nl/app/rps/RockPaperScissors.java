package nl.app.rps;

import nl.app.rps.models.*;

public class RockPaperScissors {

    private final Player player1;
    private final Player player2;
    private final GamePrinter printer;
    private final ScoreBoard scoreBoard;
    private boolean normalExit = false;

    public RockPaperScissors(Player player1, Player player2, GamePrinter printer, ScoreBoard scoreBoard) {
        this.player1 = player1;
        this.player2 = player2;

        this.printer = printer;
        this.scoreBoard = scoreBoard;

        start();
    }

    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if(!this.normalExit){
                //Print the end of the game in unnatural termination (e.g. console command control+c)
                end();
            }
        }));

        this.printer.intro();

        while (true) {
            GameOption player1Input = this.player1.getInput();
            GameOption player2Input = this.player2.getInput();
            if (player1Input == GameOption.END) {
                this.normalExit = true;
                break;
            }
            GameResult gameResult = GameResult.byInputs(player1Input, player2Input);
            updateScoreBoard(gameResult);
            printer.printResult(gameResult, player1Input.name(), player2Input.name());
        }

        this.end();
    }

    private void updateScoreBoard(GameResult gameResult){
        switch (gameResult) {
            case LOSS -> scoreBoard.setLoss(scoreBoard.getLoss() + 1);
            case DRAW -> scoreBoard.setDraw(scoreBoard.getDraw() + 1);
            case WIN -> scoreBoard.setWin(scoreBoard.getWin() + 1);
        }
    }

    private void end() {
        this.printer.score(scoreBoard.getLoss(), scoreBoard.getDraw(), scoreBoard.getWin());
    }
}
