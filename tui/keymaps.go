package tui

import "github.com/charmbracelet/bubbles/key"

type quitKeyMap struct {
	Quit key.Binding
}

type choiceKeyMap struct {
	quitKeyMap
	R, P, S key.Binding
}

type againKeyMap struct {
	quitKeyMap
	Yes, No key.Binding
}

func (k quitKeyMap) ShortHelp() []key.Binding {
	return []key.Binding{k.Quit}
}

func (k quitKeyMap) FullHelp() [][]key.Binding {
	return [][]key.Binding{
		{k.Quit}, // second column
	}
}

func (k choiceKeyMap) ShortHelp() []key.Binding {
	return []key.Binding{k.R, k.P, k.S}
}

func (k choiceKeyMap) FullHelp() [][]key.Binding {
	return [][]key.Binding{
		{k.R, k.P, k.S}, // first column
		{k.Quit},        // second column
	}
}

func (k againKeyMap) ShortHelp() []key.Binding {
	return []key.Binding{k.Yes, k.No}
}

func (k againKeyMap) FullHelp() [][]key.Binding {
	return [][]key.Binding{
		{k.Yes, k.No}, // first column
		{k.Quit},      // second column
	}
}

var quitKeys = quitKeyMap{
	Quit: key.NewBinding(
		key.WithKeys("q", "esc", "ctrl+c"),
		key.WithHelp("q", "Quit the program"),
	),
}

var choiceKeys = choiceKeyMap{
	quitKeyMap: quitKeys,
	R: key.NewBinding(
		key.WithKeys("r"),
		key.WithHelp("r", "Choose rock"),
	),
	P: key.NewBinding(
		key.WithKeys("p"),
		key.WithHelp("p", "Choose paper"),
	),
	S: key.NewBinding(
		key.WithKeys("s"),
		key.WithHelp("s", "Choose scissors"),
	),
}

var againKeys = againKeyMap{
	quitKeyMap: quitKeys,
	Yes: key.NewBinding(
		key.WithKeys("y"),
		key.WithHelp("y", "Play again"),
	),
	No: key.NewBinding(
		key.WithKeys("n"),
		key.WithHelp("n", "Quit the program"),
	),
}
