package game

import "testing"

func TestHumanPlayer_GetChoiceCanOnlyBeCalledOnceAfterSetChoice(t *testing.T) {
	player := NewHumanPlayer()
	player.SetChoice(ChoicePaper)
	choice, err := player.GetChoice()
	if err != nil {
		t.Errorf("error = %v, want %v", err, nil)
	}
	if choice != ChoicePaper {
		t.Errorf("choice = %v, want %v", choice, ChoicePaper)
	}

	_, err = player.GetChoice()
	if err != ErrChoiceNotAvailable {
		t.Errorf("error = %v, want %v", err, ErrChoiceNotAvailable)
	}

}
