package nl.hartwigmedical;

public class ComputerPlayer implements Player {

    final PlayerType playerType;
    String name;

    public ComputerPlayer() {
        playerType = PlayerType.COMPUTER;
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
