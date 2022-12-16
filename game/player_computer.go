package game

import "math/rand"

// ComputerStrategy is an interface that defines how a computer player makes a choice
type ComputerStrategy interface {
	GetChoice(history []Round) Choice
}

// RandomStrategy is a computer strategy that chooses randomly
type RandomStrategy struct{}

func (s *RandomStrategy) GetChoice(_ []Round) Choice {
	return Choices[rand.Intn(len(Choices))]
}

type ComputerPlayer struct {
	strategy ComputerStrategy
}

func (p *ComputerPlayer) GetChoice() (Choice, error) {
	// we are not keeping track of history, so history is empty
	choice := p.strategy.GetChoice([]Round{})
	return choice, nil
}

func (p *ComputerPlayer) HandleRoundResult(_ Round) {
	// we could keep track of the history and use it to make better decisions
}

func NewComputerPlayer() *ComputerPlayer {
	return &ComputerPlayer{strategy: &RandomStrategy{}}
}
