package main

import (
	"fmt"
	"os"
	"paperrockscissors/tui"

	tea "github.com/charmbracelet/bubbletea"
)

func main() {
	p := tea.NewProgram(tui.PlayerVsComputer(), tea.WithAltScreen())
	m, err := p.Run()
	if err != nil {
		fmt.Printf("Alas, there's beqen an error: %v", err)
		os.Exit(1)
	}

	if m, ok := m.(tui.Model); ok {
		fmt.Println(m.FormatGameSummary())
	}
}
