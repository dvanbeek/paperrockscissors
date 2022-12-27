package nl.hartwigmedical.players;

import nl.hartwigmedical.exceptions.InvalidPlayerNameException;

import java.util.function.Function;

public class HumanPlayer implements Player {
    final PlayerType playerType;
    String name;
    int wins = 0;
    public HumanPlayer() {
        this.playerType = PlayerType.HUMAN;
    }

    public HumanPlayer(String name) throws InvalidPlayerNameException {
        this.playerType = PlayerType.HUMAN;
        setName(name);
    }

    Function<String, Boolean> isValidName = (name) -> name.chars().allMatch(Character::isLetter);

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPlayerNameException {
        if(isValidName.apply(name)){
            this.name = name;
        } else {
            throw new InvalidPlayerNameException();
        }
    }

    @Override
    public void incrementWins() {
        wins ++;
    }

    @Override
    public int getWins() {
        return wins;
    }
}
