package computer;

import shapes.Shape;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Computer {
    private final Random rand;

    public Computer(Random rand) {
        this.rand = rand;
    }

    public Shape playRandomShape() {
        List<String> validInputs = Shape.getShapes();
        return Shape.valueOf(Shape.class, validInputs.get(rand.nextInt(validInputs.size())).toUpperCase(Locale.ROOT));
    }
}
