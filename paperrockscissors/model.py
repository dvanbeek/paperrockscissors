from dataclasses import dataclass
import enum
from typing import TypeGuard
from abc import ABC


class GameOutcome(enum.StrEnum):
    PLAYER_ONE_WIN = "player_one_win"
    """Player one has won."""

    PLAYER_TWO_WIN = "player_two_win"
    """Player two has won."""

    TIE = "tie"
    """The game is a tie."""


class PlayerMove(enum.StrEnum):
    """The moves players can do."""

    ROCK = "rock"
    """Rock beats scissors."""

    PAPER = "paper"
    """Paper beats rock."""

    SCISSORS = "scissors"
    """Scissors beats paper."""


@dataclass
class Game:
    """
    This holds the game state. This class is 'dumb' in the sense that it does
    not know about the games rules: it is simply a data container.
    """

    outcome: GameOutcome | None = None
    """Game outcome, None if the game has not yet finished."""

    player_one_move: PlayerMove | None = None
    """The move done by player one, None if player one has not yet made a move."""

    player_two_move: PlayerMove | None = None
    """The move done by player two, None if player two has not yet made a move."""


class _FinishedGame(ABC):
    """Never-instantiated class for use in the is_game_finished type guard."""

    outcome: GameOutcome
    player_one_move: PlayerMove
    player_two_move: PlayerMove


def is_game_finished(game: Game) -> TypeGuard[_FinishedGame]:
    if game.outcome is None:
        return False
    if game.player_one_move is None or game.player_two_move is None:
        return False
    return True
