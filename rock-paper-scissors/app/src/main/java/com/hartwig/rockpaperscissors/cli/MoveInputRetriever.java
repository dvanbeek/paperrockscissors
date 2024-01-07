package com.hartwig.rockpaperscissors.cli;
//todo add new package games and move cli package there

import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.hartwig.rockpaperscissors.cli.ParseException;
import com.hartwig.rockpaperscissors.model.Move;
import java.util.List;
import java.util.ArrayList;

// todo use generics and make this an Enum interpeter that you initialize with the Move class
public class MoveInputRetriever extends InputRetriever {


	@Override
	public boolean validInput(String input) {
		if (input == null) {
			return false;
		}

		try {
			Move move = Enum.valueOf(Move.class, input);
			return move != null;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public List<String> validOptions() {
		return Stream.of(Move.values())
                     .map(Move::name)
                     .collect(Collectors.toList());
	}

	public Move getMove(String query) throws ParseException {
		String input = scanForInput(query);

		try {
			return Enum.valueOf(Move.class, input);
		} catch (IllegalArgumentException e) {
			throw new ParseException("Implementation error, check validator");
		}
		
	}
}
