package tui

import (
	"fmt"
	"github.com/charmbracelet/bubbles/help"
	"github.com/charmbracelet/bubbles/key"
	tea "github.com/charmbracelet/bubbletea"
	"github.com/charmbracelet/lipgloss"
	"paperrockscissors/game"
	"strings"
)

type gameState uint

const (
	WaitingForChoice gameState = iota
	ShowingResult
)

var (
	choiceShortCut = map[string]game.Choice{
		"r": game.ChoiceRock,
		"p": game.ChoicePaper,
		"s": game.ChoiceScissors,
	}

	normal       = lipgloss.NewStyle()
	choiceString = normal.Render("Rock, Paper or Scissors?")
)

type Model struct {
	human     *game.HumanPlayer
	game      game.Game
	lastRound game.Round
	state     gameState
	help      help.Model
}

func PlayerVsComputer() Model {
	p1 := game.NewHumanPlayer()
	p2 := game.NewComputerPlayer()
	g := game.NewGame(p1, p2)
	h := help.New()
	h.ShowAll = true
	return Model{
		human: p1,
		game:  g,
		state: WaitingForChoice,
		help:  h,
	}
}

func (m Model) Init() tea.Cmd {
	return nil
}

func (m Model) Update(msg tea.Msg) (tea.Model, tea.Cmd) {
	switch msg := msg.(type) {
	case tea.WindowSizeMsg:
		m.help.Width = msg.Width
	case tea.KeyMsg:
		switch {
		case key.Matches(msg, quitKeys.Quit):
			return m, tea.Quit
		case m.state == WaitingForChoice && key.Matches(msg, choiceKeys.R, choiceKeys.P, choiceKeys.S):
			m.human.SetChoice(choiceShortCut[strings.ToLower(msg.String())])
			round, _ := m.game.PlayRound()
			m.lastRound = round
			m.state = ShowingResult
		case m.state == ShowingResult && key.Matches(msg, againKeys.Yes):
			m.state = WaitingForChoice
		case m.state == ShowingResult && key.Matches(msg, againKeys.No):
			return m, tea.Quit
		}
	}

	return m, nil
}

func (m Model) View() string {
	var s string
	if m.state == WaitingForChoice {
		s = fmt.Sprintf("%s\n\n", choiceString)
		s += m.help.View(choiceKeys)
	} else {
		s = fmt.Sprintf("%s\n\n", formatRoundResult(m.lastRound))
		s += m.help.View(againKeys)
	}

	return s
}

func formatRoundResult(round game.Round) string {
	var result string
	switch round.Result {
	case game.ResultPlayer1Wins:
		result = "You win!"
	case game.ResultPlayer2Wins:
		result = "You lose!"
	case game.ResultTie:
		result = "It's a tie!"
	default:
		result = "Unknown"
	}

	return fmt.Sprintf(
		`Your choice:       %s
Computer's choice: %s
Result:            %s

Play again?`, round.Player1, round.Player2, result)

}

func (m Model) FormatGameSummary() string {
	summary := game.Summarize(m.game.History())

	return fmt.Sprintf(`You won %d times, lost %d times and tied %d times.`, summary.Player1Wins, summary.Player2Wins, summary.Ties)
}
