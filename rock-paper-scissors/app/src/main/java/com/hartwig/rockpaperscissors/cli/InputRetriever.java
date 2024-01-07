package com.hartwig.rockpaperscissors.cli;
//todo add new package games and move cli package there

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public abstract class InputRetriever {


	private String getInput() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		return sanitize(input);
	}

	private String sanitize(String input) {
		//todo make sure no injection takes place
		return input;
	}

	public String scanForInput(String query) {
		boolean gotValidResponse = false;
		String input = null;
		System.out.println(query);
		while(!gotValidResponse) {
			System.out.println(describeValidOptions());
			input = getInput();
			gotValidResponse = validInput(input);
			if(!gotValidResponse) {
				System.out.println("That doesn't make sense to me.");
			}
		}
		return input;

	}

	abstract boolean validInput(String input);

	abstract List<String> validOptions();

	private String describeValidOptions() {
		return "You can choose one of the following options. " + validOptions();
	}
}
