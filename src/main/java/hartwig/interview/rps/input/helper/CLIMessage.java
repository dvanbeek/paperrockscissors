package hartwig.interview.rps.input.helper;

public class CLIMessage {

    public static final String WELCOME = "Welcome. You are about to start playing Rock-Paper-Scissors.";
    public static final String CONTEXT = "You are in one player mode, you will play against a computer.";
    public static final String INSTRUCTIONS = "Enter 0 for rock, 1 for paper, 2 for scissors. Good Luck!";

    public static void displayScore(int wins, int losses, int ties) {
        writeMessage("Wins: " + wins, "Losses: " + losses, "Ties: " + ties);
    }
    public static void displayIntro() {
        writeMessage(WELCOME, CONTEXT, INSTRUCTIONS);
    }

    public static void info(String message) {
        writeMessage(message);
    }

    private static void writeMessage(String msg1, String msg2, String msg3) {
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
    }
    private static void writeMessage(String msg) {
        System.out.println(msg);
    }
}
