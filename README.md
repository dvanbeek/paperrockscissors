# Paper Rock Scissors Exercise

This repository contains a simple interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)
The game is played through the CLI where the player needs to input their choice.
When the player decides to stop, the game outputs a summary of games won, lost and tied.

## Usage
First, compile the program:
```bash
mvn clean package
```

To play the game, use:
```bash
java -cp target/rockpaperscissors-1.0.0.jar games.Main
```
