package nl.hartwigmedical;

public class HumanPlayer implements Player {
    final PlayerType playerType;
    String name;

    public HumanPlayer() {
        this.playerType = PlayerType.HUMAN;
    }

    public HumanPlayer(String name) {
        this.playerType = PlayerType.HUMAN;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
