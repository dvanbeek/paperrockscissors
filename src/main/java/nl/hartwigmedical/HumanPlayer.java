package nl.hartwigmedical;

public class HumanPlayer implements Player {
    final PlayerType playerType;
    String name;

    public HumanPlayer() {
        this.playerType = PlayerType.HUMAN;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
