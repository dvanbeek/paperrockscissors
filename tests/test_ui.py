from unittest.mock import MagicMock
from typing import Any

from paperrockscissors.controller.game import RandomComputerPlayer, HumanPlayer
from paperrockscissors.controller.ui import UserInterfaceController
from paperrockscissors.model import GameOutcome, PlayerMove, is_game_finished


def _create_mock_ui() -> Any:
    """
    Create a mocked user interface so we can check if the UI controller is calling the
    correct methods.
    """
    mock_ui = MagicMock()
    mock_ui.on_game_start = MagicMock(return_value=None)
    mock_ui.on_new_game = MagicMock(return_value=None)
    mock_ui.on_needs_player_one_input = MagicMock(return_value=None)
    mock_ui.on_needs_player_two_input = MagicMock(return_value=None)
    mock_ui.on_player_input = MagicMock(return_value=None)
    mock_ui.on_game_result = MagicMock(return_value=None)
    mock_ui.on_print_stats = MagicMock(return_value=None)

    return mock_ui


def test_cpu_only() -> None:
    mock_ui = _create_mock_ui()

    player_one = RandomComputerPlayer()
    player_two = RandomComputerPlayer()
    ui_controller = UserInterfaceController(mock_ui, player_one, player_two)

    ui_controller.start()

    mock_ui.on_game_start.assert_called()

    ui_controller.new_game()

    mock_ui.on_new_game.assert_called()
    mock_ui.on_needs_player_one_input.assert_not_called()
    mock_ui.on_needs_player_two_input.assert_not_called()
    mock_ui.on_game_result.assert_called()

    ui_controller.quit()

    mock_ui.on_print_stats.assert_called()


def test_human_only() -> None:
    mock_ui = _create_mock_ui()

    player_one = HumanPlayer()
    player_two = HumanPlayer()
    ui_controller = UserInterfaceController(mock_ui, player_one, player_two)

    ui_controller.start()

    mock_ui.on_game_start.assert_called()

    ui_controller.new_game()

    mock_ui.on_new_game.assert_called()
    mock_ui.on_needs_player_one_input.assert_called()
    mock_ui.on_needs_player_two_input.assert_called()
    mock_ui.on_game_result.assert_not_called()

    ui_controller.input_move_player_one(PlayerMove.ROCK)

    mock_ui.on_player_input.assert_called()
    mock_ui.on_player_input.reset_mock()
    mock_ui.on_game_result.assert_not_called()

    ui_controller.input_move_player_two(PlayerMove.SCISSORS)
    mock_ui.on_player_input.assert_called()
    mock_ui.on_game_result.assert_called()

    ui_controller.quit()

    mock_ui.on_print_stats.assert_called()

    assert is_game_finished(ui_controller.game_history[-1])
    assert ui_controller.game_history[-1].outcome == GameOutcome.PLAYER_ONE_WIN
    assert ui_controller.game_history[-1].player_one_move == PlayerMove.ROCK
    assert ui_controller.game_history[-1].player_two_move == PlayerMove.SCISSORS


def test_multiple_games() -> None:
    mock_ui = _create_mock_ui()

    player_one = HumanPlayer()
    player_two = RandomComputerPlayer()
    ui_controller = UserInterfaceController(mock_ui, player_one, player_two)

    ui_controller.start()

    mock_ui.on_game_start.assert_called()

    ui_controller.new_game()

    mock_ui.on_new_game.assert_called()
    mock_ui.on_needs_player_one_input.assert_called()
    mock_ui.on_needs_player_two_input.assert_not_called()
    mock_ui.on_game_result.assert_not_called()

    ui_controller.input_move_player_one(PlayerMove.ROCK)

    mock_ui.on_player_input.assert_called()
    mock_ui.on_game_result.assert_called()

    mock_ui.on_game_start.reset_mock()
    mock_ui.on_new_game.reset_mock()
    mock_ui.on_needs_player_one_input.reset_mock()
    mock_ui.on_needs_player_two_input.reset_mock()
    mock_ui.on_player_input.reset_mock()
    mock_ui.on_game_result.reset_mock()

    ui_controller.new_game()

    mock_ui.on_game_start.assert_not_called()
    mock_ui.on_new_game.assert_called()
    mock_ui.on_needs_player_one_input.assert_called()
    mock_ui.on_needs_player_two_input.assert_not_called()
    mock_ui.on_game_result.assert_not_called()

    ui_controller.input_move_player_one(PlayerMove.SCISSORS)

    mock_ui.on_player_input.assert_called()
    mock_ui.on_game_result.assert_called()

    ui_controller.quit()

    mock_ui.on_print_stats.assert_called()

    assert len(ui_controller.game_history) == 2
    for game in ui_controller.game_history:
        assert is_game_finished(game)
