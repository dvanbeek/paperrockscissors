package paperrockscissors.players.strategies;

import paperrockscissors.Move;

import java.util.Random;
import java.util.Set;

public class RandomStrategy implements RpsStrategy {

    private final Random rng;

    public RandomStrategy() {
        this.rng = new Random();
    }
    @Override
    public Move calculateNextMove() {
        Set<Move> possibleMoves = Move.getAllMoves();
        return possibleMoves.stream().skip(rng.nextInt(possibleMoves.size())).findFirst().orElse(null);
    }
}
