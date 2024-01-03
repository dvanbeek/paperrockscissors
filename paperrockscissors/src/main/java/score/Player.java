package score;

public class Player {
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    public void incrementScore(Outcome outcome) {
        switch (outcome) {
            case WIN -> wins++;
            case LOSE -> losses++;
            case TIE -> ties++;
        }
    }
    
    public void printScore () {
        String format = """
                Exiting game
                "%s\twin%s
                "%s\tloss%s
                "%s\ttie%s""";
        System.out.printf(format, wins, wins == 1 ? "" : "s", 
                losses, losses == 1 ? "" : "es",
                ties, ties == 1 ? "" : "s");
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }
}
