package game

type HumanPlayer struct {
	choice *Choice
}

func (p *HumanPlayer) GetChoice() (Choice, error) {
	if p.choice == nil {
		return 0, ErrChoiceNotAvailable
	}

	choice := *p.choice
	p.choice = nil

	return choice, nil
}

func (p *HumanPlayer) SetChoice(choice Choice) {
	p.choice = &choice
}

func (p *HumanPlayer) HandleRoundResult(_ Round) {
	// do nothing
}

func NewHumanPlayer() *HumanPlayer {
	return &HumanPlayer{choice: nil}
}
