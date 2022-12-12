package hartwig.interview.rps.input.adapters;

import hartwig.interview.rps.input.interfaces.Reader;

import java.util.Scanner;

public class CLIPlayer extends InputDependantPlayer{
    protected Scanner scanner;

    public CLIPlayer(Reader reader, Scanner scanner) {
        super(reader);
        this.scanner = scanner;
    }

    @Override
    protected String getPlayerInput() {
        return scanner.next();
    }
}
