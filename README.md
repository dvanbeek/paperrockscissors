# Paper Rock Scissors Kasper implementation

Here follows a quick explanation of the project structure. This list is not exhaustive but rather serves as a minimal description that can guide you through the project.


### main:
- Game: this class is responsible for the flow of the rock paper scissors game. It also keeps track of the players and of the scores.
- io.CLI: this class is responsible for handling all user input and output.
- players.factories.ComputerPlayerFactory: This class is responsible for creating computer players with different strategies (although currently only the random strategy is implemented).
- players.factoriesHumanPlayerFactory: This class is responsible for creating human players.
- rules.DefaultRules: this class is responsible for enforcing the rock, paper, scissor rules as described in the functional requirements.
- App: entry point of the application.

### tests:
Tests are divided in two packages: unit tests and integration tests. I did not want to go too overboard with the integration tests but it servers as an example (and also serves as an useful smoke test).
