# Paper Rock Scissors

[![CircleCI](https://circleci.com/gh/flyaruu/paperrockscissors.svg?style=svg)](https://circleci.com/gh/flyaruu/paperrockscissors)

Implemented in Rust, to make it interesting, I'm not a total Rust master, but I manage, and learned some stuff on the way. Pretty happy with how it turned out, Rust has an amazingly powerful type system.

I've documented most of the public entities, but it is meant for starting discussions.

To build:
```bash
cargo build
```

To test:
```bash
cargo test
```

To run some benchmarks:
```bash
cargo bench
```

To see the docs:
```bash
cargo doc --open
```

# Paper Rock Scissors Exercise

The following is a small exercise to get an idea of your coding and design skills. We would like you to develop a simple interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)

It's intentionally not an algorithmically complex problem, so we're looking more at modelling and structure. We are trying to get a feel for how you code in a professional setting.

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


