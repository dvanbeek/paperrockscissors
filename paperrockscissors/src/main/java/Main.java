import computer.Computer;
import score.Player;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Paper Rock Scissors");
        PaperRockScissors paperRockScissors = new PaperRockScissors(new Player(), new Computer(new Random()));
        
        paperRockScissors.Play();
    }
}
