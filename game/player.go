package game

import "fmt"

var (
	ErrChoiceNotAvailable = fmt.Errorf("choice not available")
)

// The game should call GetChoice() and HandleRoundResult on each player every round
// We might consider only adding HandleRoundResult to computer players

type Player interface {
	GetChoice() (Choice, error)
	HandleRoundResult(result Round)
}
