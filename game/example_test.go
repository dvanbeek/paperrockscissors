package game

import (
	"fmt"
	"testing"
)

func TestGame_SimulateCLIGame(t *testing.T) {
	player1 := NewHumanPlayer()
	player2 := NewComputerPlayer()
	game := NewGame(player1, player2)

	plays := []Choice{ChoicePaper, ChoiceRock, ChoiceScissors, ChoicePaper, ChoiceRock, ChoiceScissors, ChoicePaper, ChoiceRock, ChoiceScissors}

	for _, play := range plays {
		player1.SetChoice(play)
		round, _ := game.PlayRound()
		fmt.Printf("Player 1: %v, Player 2: %v, Result: %v\n", round.Player1, round.Player2, round.Result)
	}
}
