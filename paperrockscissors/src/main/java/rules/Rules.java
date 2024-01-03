package rules;

import score.Outcome;
import shapes.Shape;

import java.util.Map;

import static shapes.Shape.*;
import static shapes.Shape.PAPER;



public class Rules {
    public static final Map<Shape, Shape> WIN_CONDITIONS = Map.of(
            PAPER, ROCK,
            ROCK, SCISSORS,
            SCISSORS, PAPER
    );

    public static Outcome playRound(Shape playerShape, Shape computerShape) {
        if (playerShape.equals(computerShape)) {
            return Outcome.TIE;
        } if (WIN_CONDITIONS.get(playerShape).equals(computerShape)) {
            return Outcome.WIN;
        }
        return Outcome.LOSE;
    }
}
