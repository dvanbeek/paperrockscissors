# Paper Rock Scissors Exercise

The following is a small exercise to get an idea of your coding and design skills. We would like you to develop a simple interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)

It's intentionally not an algorithmically complex problem, so we're looking more at modelling and structure. We are trying to get a feel for how you code in a professional setting.

## Python solution of Maurits Dijkstra

This is my solution, written in Python. A few of the considerations:
* Try to separate as much general UI / game logic to increase unit testability.
* Add ability to easily implement a second UI type (f.e. a GUI).
* Additional CPU strategies not supported, but should be easy to add.
* Roughly structure the code as Model-View-Controller (MVC).
* Use as modern a Python environment as possible (typing, Poetry for dependencies, etc.)
* Add a small (unoptimized) Dockerfile because we can. :-)

### Running the game

If you've got Python 3.11 / Poetry already setup, you can simply check out the source
and do:
```bash
$ poetry install --without dev
$ poetry run prs --help
```

If you don't have the dependencies, you can run the game through the provided Docker
image definition -- after again first checking out the source code:
```bash
$ docker build -t mauritsd/paperrockscissors .
$ docker run -it --rm mauritsd/paperrockscissors prs --help
```

### Running the tests

If you've already installed the Poetry environment in the previous step you can run
the following command to run the test suite:
```bash
$ poetry run pytest
```

If you've chosen to build the Docker image instead, you can do:
```bash
$ docker run -it --rm mauritsd/paperrockscissors pytest
```

## Functional Requirements
* The user is presented with a CLI to play the game.
* A user can enter one of 3 inputs: paper, rock or scissors.
* The computer will choose one input at random.
* The game rules will be applied and a winner is chosen:
  - Paper beats Rock
  - Rock beats Scissors
  - Scissors beats Paper.
  - The same input is a tie.
* The game will repeat until the user explictly chooses to exit.
* On exit a summary is displayed of games won, lost, and tied.

## Non-Functional Requirements
* Create a branch of this repo and submit your solution as a PR.
* You can use any language you like, but we'd like to see your object oriented design skills, so best to use a language supporting OO.
* Write your code to the same standard you would professionally (object structure, design patterns, readability, testing/testability, extensibility)
* Write some unit tests for the key pieces of logic.
* Don't go overboard, this should only take a few hours.




