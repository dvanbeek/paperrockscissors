package game

import (
	"reflect"
	"testing"
)

type mockPlayer struct {
	choice            Choice
	roundResultCalled int
}

func (m *mockPlayer) GetChoice() (Choice, error) {
	return m.choice, nil
}

func (m *mockPlayer) HandleRoundResult(_ Round) {
	m.roundResultCalled++
}

func Test_Game_ValidateGameResults(t *testing.T) {
	type args struct {
		player1 Choice
		player2 Choice
	}
	tests := []struct {
		name string
		args args
		want Result
	}{
		{name: "Paper beats Rock", args: args{player1: ChoicePaper, player2: ChoiceRock}, want: ResultPlayer1Wins},
		{name: "Rock beats Scissors", args: args{player1: ChoiceRock, player2: ChoiceScissors}, want: ResultPlayer1Wins},
		{name: "Scissors beats Paper", args: args{player1: ChoiceScissors, player2: ChoicePaper}, want: ResultPlayer1Wins},
		{name: "Paper loses to Scissors", args: args{player1: ChoicePaper, player2: ChoiceScissors}, want: ResultPlayer2Wins},
		{name: "Rock loses to Paper", args: args{player1: ChoiceRock, player2: ChoicePaper}, want: ResultPlayer2Wins},
		{name: "Scissors loses to Rock", args: args{player1: ChoiceScissors, player2: ChoiceRock}, want: ResultPlayer2Wins},
		{name: "Tie Paper", args: args{player1: ChoicePaper, player2: ChoicePaper}, want: ResultTie},
		{name: "Tie Rock", args: args{player1: ChoiceRock, player2: ChoiceRock}, want: ResultTie},
		{name: "Tie Scissors", args: args{player1: ChoiceScissors, player2: ChoiceScissors}, want: ResultTie},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			p1 := &mockPlayer{choice: tt.args.player1}
			p2 := &mockPlayer{choice: tt.args.player2}
			g := NewGame(p1, p2)
			if got, _ := g.PlayRound(); got.Result != tt.want {
				t.Errorf("Play() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_Game_Play_InvalidChoiceGameResults(t *testing.T) {
	type args struct {
		player1 Choice
		player2 Choice
	}
	tests := []struct {
		name string
		args args
	}{
		{name: "Player 1 InvalidChoice", args: args{player1: Choice(0), player2: ChoiceRock}},
		{name: "Player 2 InvalidChoice", args: args{player1: ChoicePaper, player2: Choice(0)}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			p1 := &mockPlayer{choice: tt.args.player1}
			p2 := &mockPlayer{choice: tt.args.player2}
			g := NewGame(p1, p2)
			if _, err := g.PlayRound(); err != ErrInvalidChoice {
				t.Errorf("error = %v, want %v", err, ErrInvalidChoice)
			}
		})
	}
}

func Test_Game_HistoryShouldContainAllValidRounds(t *testing.T) {
	p1 := &mockPlayer{choice: Choice(0)}
	p2 := &mockPlayer{choice: Choice(0)}
	game := NewGame(p1, p2)

	test := []struct {
		p1, p2  Choice
		history []Round
	}{
		{ChoicePaper, ChoiceRock,
			[]Round{{Player1: ChoicePaper, Player2: ChoiceRock, Result: ResultPlayer1Wins}}},
		{ChoiceRock, ChoicePaper,
			[]Round{
				{Player1: ChoicePaper, Player2: ChoiceRock, Result: ResultPlayer1Wins},
				{Player1: ChoiceRock, Player2: ChoicePaper, Result: ResultPlayer2Wins}}},
		{Choice(0), ChoicePaper,
			[]Round{
				{Player1: ChoicePaper, Player2: ChoiceRock, Result: ResultPlayer1Wins},
				{Player1: ChoiceRock, Player2: ChoicePaper, Result: ResultPlayer2Wins}}},
		{ChoiceScissors, ChoiceScissors,
			[]Round{
				{Player1: ChoicePaper, Player2: ChoiceRock, Result: ResultPlayer1Wins},
				{Player1: ChoiceRock, Player2: ChoicePaper, Result: ResultPlayer2Wins},
				{Player1: ChoiceScissors, Player2: ChoiceScissors, Result: ResultTie}}},
	}

	for _, tt := range test {
		p1.choice = tt.p1
		p2.choice = tt.p2
		_, _ = game.PlayRound()
		if got := game.History(); !reflect.DeepEqual(got, tt.history) {
			t.Errorf("History() = %v, want %v", got, tt.history)
		}
	}

}

func Test_Game_HandleRoundResultCalled(t *testing.T) {
	p1 := &mockPlayer{choice: ChoicePaper}
	p2 := &mockPlayer{choice: ChoiceRock}
	game := NewGame(p1, p2)
	_, _ = game.PlayRound()
	if p1.roundResultCalled != 1 {
		t.Errorf("HandleRoundResult() = %v, want %v", p1.roundResultCalled, 1)
	}
	if p2.roundResultCalled != 1 {
		t.Errorf("HandleRoundResult() = %v, want %v", p2.roundResultCalled, 1)
	}
}

func TestSummarize(t *testing.T) {
	p1 := &mockPlayer{choice: Choice(0)}
	p2 := &mockPlayer{choice: Choice(0)}
	game := NewGame(p1, p2)

	test := []struct {
		p1, p2 Choice
	}{
		{ChoicePaper, ChoiceRock},     // Player 1 wins
		{ChoiceRock, ChoicePaper},     // Player 2 wins
		{ChoiceScissors, ChoicePaper}, // Player 1 wins
		{ChoiceRock, ChoicePaper},     // Player 2 wins
		{ChoiceRock, ChoiceScissors},  // Player 1 wins
		{ChoiceRock, ChoicePaper},     // Player 2 wins
		{ChoiceRock, ChoiceRock},      // Tie
	}

	for _, tt := range test {
		p1.choice = tt.p1
		p2.choice = tt.p2
		_, _ = game.PlayRound()
	}

	expected := Summary{
		Player1Wins: 3,
		Player2Wins: 3,
		Ties:        1,
	}

	if got := Summarize(game.History()); !reflect.DeepEqual(got, expected) {
		t.Errorf("Summarize() = %v, want %v", got, expected)
	}
}
