# Paper Rock Scissors Exercise

The following code provides a simple yet well designed interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)

The solution has been designed with the following objectives in mind:

- **Maintainability**: With well-defined classes and methods, maintaining the code becomes easier. Each class has a single responsibility, making it easier to identify where changes are needed.
- **Readability**: The code is self-documenting due to meaningful methods and variable names. The added JavaDoc comments further enhance understanding.
- **Scalability**: With the use of interfaces and encapsulation, adding new features or modifying existing ones becomes more straightforward.
- **Robustness**: Exception handling ensures the game doesn’t break unexpectedly. Users are guided with appropriate feedback.
- **Modularity**: The separation of concerns and well-defined boundaries between classes ensures high cohesion and low coupling, which is an important point of modular design.

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

## Implementation

- App.java: performs the necessary instantiations and dependency injections to the main components of the game and then starts the game engine.

## Future improvements

- Additional comments, in particular to public methods. Some have been ommitted due to time constraints and self explanation of the code.
- Additional unit test. Although many important unit tests are provided with this code, additional unit tests can be written to improve the coverage. Areas for further unit tests are:
  - App.java: currently missing any tests, because it only performs the necessary instantiations of components, and these components are all being tested to a certain degree.
