package nl.app.rps.models;

public interface GamePrinter {
    void intro();
    void score(int loss, int draw, int win);

    void printResult(GameResult gameResult, String input, String player2Input);
}
