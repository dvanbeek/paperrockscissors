package shapes;

import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public enum Shape {
    PAPER, ROCK, SCISSORS;
    
    public static List<String> getShapes() {
        EnumSet<Shape> shapes = EnumSet.allOf(Shape.class);
        return shapes.parallelStream().map(shape -> shape.name().toLowerCase(Locale.ROOT)).collect(Collectors.toList());
    }
    
    public static Shape getShape(String input) {
        EnumSet<Shape> shapes = EnumSet.allOf(Shape.class);
        return shapes.stream().filter(shape -> shape.name().equals(input.toUpperCase(Locale.ROOT)) || 
                (input.length() == 1 && shape.name().startsWith(input.toUpperCase(Locale.ROOT)))).findFirst().orElse(null);
    }
}
