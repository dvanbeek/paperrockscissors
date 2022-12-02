package org.ysbijl;

import java.util.Arrays;
import java.util.Scanner;

public class UPC extends Player {
    Scanner userInput = new Scanner(System.in);

    public String askUserChoice(String[] options, String question) {
        String userChoice= "";
        while (!(Arrays.asList(options).contains(userChoice))) { // Ensure only valid options are given by user
            System.out.println(question);
            userChoice = userInput.nextLine().toLowerCase();
        }
        return userChoice;
    }
}
