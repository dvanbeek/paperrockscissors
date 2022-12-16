package game

import (
	"fmt"
	"golang.org/x/exp/slices"
)

var (
	ErrInvalidChoice = fmt.Errorf("invalid move")
)

type Choice uint8

const (
	ChoicePaper Choice = iota + 1
	ChoiceRock
	ChoiceScissors
)

var Choices = []Choice{ChoicePaper, ChoiceRock, ChoiceScissors}

func (c Choice) String() string {
	switch c {
	case ChoicePaper:
		return "Paper"
	case ChoiceRock:
		return "Rock"
	case ChoiceScissors:
		return "Scissors"
	default:
		return "Unknown"
	}
}

type Result uint8

const (
	ResultTie Result = iota + 1
	ResultPlayer1Wins
	ResultPlayer2Wins
)

func (r Result) String() string {
	switch r {
	case ResultPlayer1Wins:
		return "Player 1 wins"
	case ResultPlayer2Wins:
		return "Player 2 wins"
	case ResultTie:
		return "Tie"
	default:
		return "Unknown"
	}
}

type Round struct {
	Player1 Choice
	Player2 Choice
	Result  Result
}

type Game struct {
	player1 Player
	player2 Player
	history []Round
}

func (g *Game) PlayRound() (round Round, err error) {
	var result Result
	choice1, err := g.player1.GetChoice()
	if err != nil {
		return
	}
	choice2, err := g.player2.GetChoice()
	if err != nil {
		return
	}

	if !slices.Contains(Choices, choice1) || !slices.Contains(Choices, choice2) {
		return Round{}, ErrInvalidChoice
	}

	if choice1 == choice2 {
		result = ResultTie
	} else if choice1 == ChoicePaper && choice2 == ChoiceRock {
		result = ResultPlayer1Wins
	} else if choice1 == ChoiceRock && choice2 == ChoiceScissors {
		result = ResultPlayer1Wins
	} else if choice1 == ChoiceScissors && choice2 == ChoicePaper {
		result = ResultPlayer1Wins
	} else {
		result = ResultPlayer2Wins
	}

	round = Round{Player1: choice1, Player2: choice2, Result: result}
	g.history = append(g.history, round)

	g.player1.HandleRoundResult(round)
	g.player2.HandleRoundResult(round)

	return
}

func (g *Game) History() []Round {
	return g.history
}

func NewGame(player1, player2 Player) Game {
	return Game{
		player1: player1,
		player2: player2,
		history: make([]Round, 0),
	}
}

type Summary struct {
	Player1Wins int
	Player2Wins int
	Ties        int
}

func Summarize(r []Round) Summary {
	var p1Wins, p2Wins, ties int
	for _, round := range r {
		switch round.Result {
		case ResultPlayer1Wins:
			p1Wins++
		case ResultPlayer2Wins:
			p2Wins++
		case ResultTie:
			ties++
		}
	}

	return Summary{
		Player1Wins: p1Wins,
		Player2Wins: p2Wins,
		Ties:        ties,
	}
}
