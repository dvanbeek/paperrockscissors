package com.hartwigtest.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.hartwigtest.model.MoveKind;

final class CommandLine implements UserInterface {
    private Scanner scanner;

    public CommandLine() {
        scanner = new Scanner(System.in);
    }

    public CommandLine(String inputFileName) {
        try {
            scanner = new Scanner(new File(inputFileName));
        } catch (FileNotFoundException exception) {
            writeMessage("Switch to System.in as can't open input file:" + exception.toString());
            scanner = new Scanner(System.in);
        }
    }

    @Override
    public MoveKind readMove(String playerName) {
        String input = "";
        while (input.isEmpty()) {
            writeMessage("Player '" + playerName
                    + "' please make your move by pressing 'r' (ROCK), 'p' (PAPER), 's' (SCISSORS), 'q' (QUIT the game).");
            input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) {
                continue;
            }
            switch (input.charAt(0)) {
                case 'r':
                    return MoveKind.ROCK;

                case 'p':
                    return MoveKind.PAPER;

                case 's':
                    return MoveKind.SCISSORS;

                case 'q':
                    return null;

                default:
                    writeMessage("The input is not correct, try again.");
                    input = "";
            }
        }
        return null;
    }

    public void writeMessage(String message) {
        System.out.println(message);
    };

}