package com.hartwig.rockpaperscissors.cli;
//todo add new package games and move cli package there

import com.hartwig.rockpaperscissors.cli.ParseException;
import java.util.List;
import java.util.ArrayList;

public class BooleanInputRetriever extends InputRetriever {


	@Override
	public boolean validInput(String input) {
		if (input == null) {
			return false;
		}
		if (input.equals("y") || input.equals("n")) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> validOptions() {
		return new ArrayList<String>() {
            {
                add("y");
                add("n");
            }
        };
	}

	public boolean getBooleanInput(String query) throws ParseException {
		String input = scanForInput(query);

		if (input.equals("y")) {
			return true;
		}

		if (input.equals("n")) {
			return false;
		}
		throw new ParseException(input);
	}
}
