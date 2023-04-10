package model;

import java.util.Objects;
import java.util.UUID;

public abstract class Player {

    private Move move;
    private final String name;
    private final UUID uniqueIdentifier;


    public Player(String name) {
        if (name == null) {
            throw new NullPointerException("Name must be initialized");
        }
        this.name = name;
        this.uniqueIdentifier = UUID.randomUUID();
    }

    public String getName() {
        return this.name;
    }

    public Move getMove() {
        return this.move;
    }

    public void setMove(Move move) {
        if (move == null) {
            throw new NullPointerException("Move must be non-null!");
        }
        this.move = move;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) && uniqueIdentifier.equals(player.uniqueIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uniqueIdentifier);
    }
}
