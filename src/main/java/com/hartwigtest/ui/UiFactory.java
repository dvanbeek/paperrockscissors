package com.hartwigtest.ui;

public final class UiFactory {
    public static UserInterface creatUserInterface() {
        return new CommandLine();
    }

    public static UserInterface creatUserInterface(String inputFileName) {
        return new CommandLine(inputFileName);
    }
}
