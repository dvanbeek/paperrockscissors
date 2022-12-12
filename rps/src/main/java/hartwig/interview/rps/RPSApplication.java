package hartwig.interview.rps;

import hartwig.interview.rps.domain.ports.GameManager;
import hartwig.interview.rps.input.adapters.ComputerPlayer;
import hartwig.interview.rps.input.adapters.InputDependantPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class RPSApplication  extends InputDependantPlayer implements CommandLineRunner{

	public static final String WELCOME = "Welcome. You are about to start playing Rock-Paper-Scissors.";
	public static final String CONTEXT = "You are in one player mode, you will play against a computer.";
	public static final String INSTRUCTIONS = "Enter 0 for rock, 1 for paper, 2 for scissors. Good Luck!";
	Scanner scanner;
	GameManager gameManager;

	public static void main(String[] args) {
		SpringApplication.run(RPSApplication.class, args);
	}

	@Override
	public void run(String... args) {
		initializeGame();
		displayIntro(WELCOME, CONTEXT, INSTRUCTIONS);

		gameManager.playRound();

		for(;;){
			writeMessage("Do you want to play another round? Y/N");
			var continueGame = scanner.next();
			if(continueGame.equalsIgnoreCase("n"))
				break;
			else if(continueGame.equalsIgnoreCase("y"))
				gameManager.playRound();
			else
				writeMessage("Plese enter Y or N to continue.");
		}
		var score = gameManager.endGame();
		displayScore("WINS: " + score.getPlayerScore(this.toString()).getWins(),
				"LOSSES: " + score.getPlayerScore(this.toString()).getLosses(),
				"TIES: " + score.getPlayerScore(this.toString()).getTies()
		);
	}

	private void initializeGame() {
		scanner = new Scanner(System.in);
		var player1 = new ComputerPlayer();
		gameManager = new GameManager(this, player1);
		writeMessage("Rock-paper-scissors: GO!");
	}

	private static void displayScore(String wins, String losses, String ties) {
		writeMessage(wins, losses, ties);
	}
	private static void displayIntro(String welcome, String context, String insturctions) {
		writeMessage(welcome, context, insturctions);
	}

	private static void writeMessage(String msg1, String msg2, String msg3) {
		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg3);
	}
	private static void writeMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public String getPlayerInput() {
		return scanner.next();
	}
}
