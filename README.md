# Paper Rock Scissors Solution

The following code provides a simple yet well designed interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)

The solution has been designed with the following objectives in mind:

- **Maintainability**: With well-defined classes and methods, maintaining the code becomes easier. Each class has a single responsibility, making it easier to test and to identify where changes are needed.
- **Readability**: The code is self-documenting due to meaningful methods and variable names. The added JavaDoc comments further enhance understanding.
- **Scalability**: With the use of interfaces and encapsulation, adding new features or modifying existing ones becomes more straightforward.
- **Robustness**: Exception handling ensures the game doesn’t break unexpectedly. Users are guided with appropriate feedback.
- **Modularity**: The separation of concerns and well-defined boundaries between classes ensures high cohesion and low coupling, which is an important point of modular design and facilitates for unit testing.

## Functionality

- The user is presented with a CLI to play the game.
- A user can enter one of 3 inputs: paper, rock or scissors.
- The computer will choose one input at random.
- The game rules will be applied and a winner is chosen:

  - Paper beats Rock
  - Rock beats Scissors
  - Scissors beats Paper.
  - The same input is a tie.

- The game will repeat until the user explictly chooses to exit.
- On exit a summary is displayed of games won, lost, and tied.

## Solution Design

- **App.java**: performs the necessary instantiations and dependency injections to the main components of the game and then starts the game engine.

- \engine

  - **GameControls.java**: Provides game controls for human player, currently being injected with keyboard scanner and providing a method (getPlayerMove) to parse input from human player and return a MoveEnum object.
  - **GameEngine.java**: Provides a start method consisting of a while loop that is exited upon receiving a QuitGameException from GameControls.

- \exceptions

  - **InvalidMoveException.java**: Indicates an invalid move
  - **QuitGameException.java**: Indicates a quit game request

- \model
  - **PlayerInterface.java**: Classes that implement this PlayerInterface must provide a getMove method that returns a MoveEnum object.
  - **HumanPlayer.java**: Implements PlayerInterface.getMove() by using GameControls to identify move.
  - **ComputerPlayer.java**: Implements PlayerInterface.getMove() by generating random computer move from the available options defined in MoveEnum.
  - **Rules.java**: Contains a Map of rules (what beats what) and a static method to return the result based on the moves of 2 players.
  - **MoveEnum.java**: Enumerates the possible moves (currently PAPER, ROCK, SCISSORS, but extendible). Defines private static unmodifiable map of string representations to corresponding MoveEnum constants. Provides method enumConstantFromCharacter that converts input string to lowercase and looks up input in Map of MoveEnum constants. Provides method getNumberOfMoveOptions that returns the total number of possible moves.
  - **RoundResultEnum.java**: Enumerates the possible outcomes (currently PLAYER1_WINS, PLAYER2_WINS, TIE, but extendible).

## Testing

Run the command `mvn jacoco:prepare-agent test install jacoco:report` to execute tests and generate a JaCoCo report.

## Future improvements

- Additional comments, in particular to public methods. Some have been ommitted due to time constraints and self explanation of the code.
- Additional unit test. Although many important unit tests are provided with this code, additional unit tests can be written to improve the coverage. Areas for further unit tests are:
  - App.java: currently missing any tests, because it only performs the necessary instantiations of components, and these components are all being tested to a certain degree.
  - Rules.java: currently missing is test on calling evaluateMoves with invalid player1Move. This scenario should not happen in the complete app because the validity check of player1Move is performed in the GameControls using MoveEnum.
- Additional robustness: add additional exception handlers for scenarios related to the scanner.
- Possible other gaming enhancements such as:
  - Keeping track of names and highscores in a file or database.
  - Auto exit the game after a certain time of inactivity.
  - A graphical user interface, potentially React based front-end with the back-end rewritten so that it becomes a server providing relevant APIs to the front-end.
