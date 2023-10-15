import pytest

from paperrockscissors.model import GameOutcome, PlayerMove
from paperrockscissors.controller.game import GameController, Player, HumanPlayer


class _RockPlayer(Player):
    def get_move(self) -> PlayerMove:
        return PlayerMove.ROCK


class _PaperPlayer(Player):
    def get_move(self) -> PlayerMove:
        return PlayerMove.PAPER


class _ScissorsPlayer(Player):
    def get_move(self) -> PlayerMove:
        return PlayerMove.SCISSORS


def test_ties() -> None:
    game_one = GameController(_RockPlayer(), _RockPlayer())
    game_one.new_game()
    game_one.resolve_game()
    assert game_one.state.outcome == GameOutcome.TIE

    game_two = GameController(_PaperPlayer(), _PaperPlayer())
    game_two.new_game()
    game_two.resolve_game()
    assert game_two.state.outcome == GameOutcome.TIE

    game_three = GameController(_ScissorsPlayer(), _ScissorsPlayer())
    game_three.new_game()
    game_three.resolve_game()
    assert game_three.state.outcome == GameOutcome.TIE


def test_player_one_wins() -> None:
    game_one = GameController(_RockPlayer(), _ScissorsPlayer())
    game_one.new_game()
    game_one.resolve_game()
    assert game_one.state.outcome == GameOutcome.PLAYER_ONE_WIN

    game_two = GameController(_PaperPlayer(), _RockPlayer())
    game_two.new_game()
    game_two.resolve_game()
    assert game_two.state.outcome == GameOutcome.PLAYER_ONE_WIN

    game_three = GameController(_ScissorsPlayer(), _PaperPlayer())
    game_three.new_game()
    game_three.resolve_game()
    assert game_three.state.outcome == GameOutcome.PLAYER_ONE_WIN


def test_player_two_wins() -> None:
    game_one = GameController(_RockPlayer(), _PaperPlayer())
    game_one.new_game()
    game_one.resolve_game()
    assert game_one.state.outcome == GameOutcome.PLAYER_TWO_WIN

    game_two = GameController(_PaperPlayer(), _ScissorsPlayer())
    game_two.new_game()
    game_two.resolve_game()
    assert game_two.state.outcome == GameOutcome.PLAYER_TWO_WIN

    game_three = GameController(_ScissorsPlayer(), _RockPlayer())
    game_three.new_game()
    game_three.resolve_game()
    assert game_three.state.outcome == GameOutcome.PLAYER_TWO_WIN


def test_multiple_games() -> None:
    player_one = HumanPlayer()
    player_two = _PaperPlayer()

    with pytest.raises(AssertionError):
        player_one.get_move()

    player_one.input_move(PlayerMove.SCISSORS)

    game = GameController(player_one, player_two)

    with pytest.raises(AssertionError):
        game.resolve_game()

    game.new_game()
    player_one.input_move(PlayerMove.PAPER)

    with pytest.raises(AssertionError):
        player_one.input_move(PlayerMove.SCISSORS)

    game.resolve_game()

    assert game.state.outcome == GameOutcome.TIE
    with pytest.raises(AssertionError):
        game.resolve_game()

    game.new_game()

    with pytest.raises(AssertionError):
        game.resolve_game()
    with pytest.raises(AssertionError):
        player_one.get_move()

    player_one.input_move(PlayerMove.ROCK)

    game.resolve_game()

    assert game.state.outcome == GameOutcome.PLAYER_TWO_WIN
