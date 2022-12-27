package nl.hartwigmedical;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private static final List<String> RANDOM_NAMES = Arrays.asList("Jimmy","Joe","Randy");
    final PlayerType playerType;
    String name;

    public ComputerPlayer() {
        this.playerType = PlayerType.COMPUTER;
        this.name = getRandomName();
    }

    @Override
    public String getName() {
        return name;
    }

    private String getRandomName(){
        Random random = new Random();
        return RANDOM_NAMES.get(random.nextInt(RANDOM_NAMES.size()));
    }
}
