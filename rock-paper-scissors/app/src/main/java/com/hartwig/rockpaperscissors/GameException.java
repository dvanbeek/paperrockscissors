package com.hartwig.rockpaperscissors;

public class GameException extends Exception {

	private String message;

	public GameException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
