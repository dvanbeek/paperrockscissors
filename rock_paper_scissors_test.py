import unittest
from unittest.mock import patch
from rock_paper_scissors import rock_paper_scissors, summary

class TestRockPaperScissors(unittest.TestCase):

    @patch('builtins.input', side_effect=['rock'])
    @patch('random.choice', return_value='scissors')
    def test_rock_beats_scissors(self, mock_input, mock_choice):
        result = rock_paper_scissors()
        self.assertEqual(result, 'win')

    @patch('builtins.input', side_effect=['rock'])
    @patch('random.choice', return_value='paper')
    def test_paper_beats_rock(self, mock_input, mock_choice):
        result = rock_paper_scissors()
        self.assertEqual(result, 'lose')

    @patch('builtins.input', side_effect=['rock'])
    @patch('random.choice', return_value='rock')
    def test_rock_tie(self, mock_input, mock_choice):
        result = rock_paper_scissors()
        self.assertEqual(result, 'tie')
        
    def test_summary(self):
        expected_output = "\nGames played: 3\nGames won: 1\nGames lost: 1\nGames tied: 1\n"
        self.assertEqual(summary(1, 1, 1), expected_output)