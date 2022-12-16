package game

import "testing"

func TestRandomStrategy_ValidateRandomness(t *testing.T) {
	strategy := &RandomStrategy{}
	results := make(map[Choice]int)

	for i := 0; i < 1000; i++ {
		choice := strategy.GetChoice([]Round{})
		results[choice]++
	}

	// we expect each choice to be returned about 333 times
	// this test might be a little brittle, but it's good enough for now
	for _, choice := range Choices {
		if results[choice] < 300 || results[choice] > 366 {
			t.Errorf("choice %v was returned %v times, expected 333", choice, results[choice])
		}
	}
}
