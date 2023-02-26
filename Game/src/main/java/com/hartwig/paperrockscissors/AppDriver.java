package com.hartwig.paperrockscissors;

import com.hartwig.paperrockscissors.input.CommandLineSupplier;
import com.hartwig.paperrockscissors.input.RandomNumberSupplier;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.hartwig.paperrockscissors.util.GameUtils.*;

public class AppDriver {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter user name");
            Player player1 = new Player(parseUserName(inputReader.readLine()), new CommandLineSupplier(inputReader));
            Player player2 = new Player(COMPUTER_USER_NAME, new RandomNumberSupplier(LOWER_BOUND, UPPER_BOUND));
            new Game(player1, player2).run();
        } catch (Exception e) {
            System.out.println("Error while running Rock Paper Scissors. Exiting program!");
            throw e;
        }
    }
}
