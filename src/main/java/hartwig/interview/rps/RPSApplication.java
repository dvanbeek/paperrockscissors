package hartwig.interview.rps;

import hartwig.interview.rps.domain.ports.GameManager;
import hartwig.interview.rps.domain.ports.Player;
import hartwig.interview.rps.input.InputReader;
import hartwig.interview.rps.input.adapters.CLIPlayer;
import hartwig.interview.rps.input.adapters.ComputerPlayer;
import hartwig.interview.rps.input.adapters.InputDependantPlayer;
import hartwig.interview.rps.input.helper.CLIMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class RPSApplication implements CommandLineRunner{

	Scanner scanner;
	GameManager gameManager;

	public static void main(String[] args) {
		SpringApplication.run(RPSApplication.class, args);
	}

	@Override
	public void run(String... args) {
		CLIMessage.displayIntro();
		var playerMode = initializeGameForCLIPlayer();

		for(;;){
			gameManager.playRound();
			CLIMessage.info("Do you want to play another round? Y/N");
			var continueGame = scanner.next();

			if(!isValidDecision(continueGame)) {
				for(;;) {
					CLIMessage.info("Plese enter Y or N to continue.");
					continueGame = scanner.next();
					if(isValidDecision(continueGame))
						break;
				}
			}

			if(continueGame.equalsIgnoreCase("n")) {
				break;
			}

		}
		var score = gameManager.endGame();
		var playerModeScore = score.getPlayerScore(playerMode.toString());
		CLIMessage.displayScore(playerModeScore.getWins(), playerModeScore.getLosses(), playerModeScore.getTies());
	}

	private static boolean isValidDecision(String continueGame) {
		return continueGame.equalsIgnoreCase("n") || continueGame.equalsIgnoreCase("y");
	}

	private Player initializeGameForCLIPlayer() {
		scanner = new Scanner(System.in);
		var player1 = new CLIPlayer(new InputReader(), scanner);
		var player2 = new ComputerPlayer();
		gameManager = new GameManager(player1, player2);
		CLIMessage.info("Rock-paper-scissors: GO!");
		return player1;
	}



}
