package com.hartwig.rockpaperscissors.cli;
//todo add new package games and move cli package there

public class ParseException extends Exception {

	private String input;

	public ParseException(String input) {
		this.input = input;
	}

	public String getInput() {
		return this.input;
	}
}
