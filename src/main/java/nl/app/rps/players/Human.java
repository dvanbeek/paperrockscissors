package nl.app.rps.players;

import nl.app.rps.models.GameOption;
import nl.app.rps.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Human implements Player {
    @Override
    public GameOption getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return parseInput(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private GameOption parseInput(BufferedReader read) throws IOException {
        String line = String.valueOf((char) read.read());
        String s = line.toLowerCase(Locale.ROOT);
        return switch (s) {
            case "r" -> GameOption.ROCK;
            case "p" -> GameOption.PAPER;
            case "s" -> GameOption.SCISSORS;
            case "e" -> GameOption.END;
            default -> parseInput(read); //Invalid character read next.
        };

    }
}
