package org.ysbijl;

import java.util.Arrays;
import java.util.Scanner;

public class UPC extends Player {
    Scanner userInput = new Scanner(System.in);

    public String askUserMove(String[] options) {
        String userMove= "";
        while (!(Arrays.asList(options).contains(userMove))) {
            System.out.println("What move will you make? (rock/paper/scissors)");
            userMove = userInput.nextLine();
        }
        return userMove;
    }
}
