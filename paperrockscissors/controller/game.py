from abc import ABC, abstractmethod
import random

from paperrockscissors.model import PlayerMove, Game, GameOutcome


class Player(ABC):
    """
    Abstract base class for players. (In Java this would be an interface and not a class
    at all.)
    """

    @abstractmethod
    def get_move(self) -> PlayerMove:
        """
        Get the move of the player. Depending on the implementation this may be a
        constant, a move input by a Human or a move chosen by some computer algorithm.
        """
        pass


class HumanPlayer(Player):
    _move: PlayerMove | None = None

    @property
    def move(self) -> PlayerMove | None:
        return self._move

    def reset_move(self) -> None:
        """Reset the current move in case of a new game."""
        self._move = None

    def input_move(self, move: PlayerMove):
        """Input a move to be returned in the current game."""
        assert self._move is None, "a move has already been input by this player"

        self._move = move

    def get_move(self) -> PlayerMove:
        assert self._move is not None, "no move has yet been input by this player"

        return self._move


class RandomComputerPlayer(Player):
    def get_move(self) -> PlayerMove:
        return random.choice([PlayerMove.ROCK, PlayerMove.PAPER, PlayerMove.SCISSORS])


_OUTCOMES: dict[tuple[PlayerMove, PlayerMove], GameOutcome] = {
    # All pairs that tie.
    (PlayerMove.ROCK, PlayerMove.ROCK): GameOutcome.TIE,
    (PlayerMove.PAPER, PlayerMove.PAPER): GameOutcome.TIE,
    (PlayerMove.SCISSORS, PlayerMove.SCISSORS): GameOutcome.TIE,
    # All player one winning pairs.
    (PlayerMove.ROCK, PlayerMove.SCISSORS): GameOutcome.PLAYER_ONE_WIN,
    (PlayerMove.PAPER, PlayerMove.ROCK): GameOutcome.PLAYER_ONE_WIN,
    (PlayerMove.SCISSORS, PlayerMove.PAPER): GameOutcome.PLAYER_ONE_WIN,
    # All player two winning pairs.
    (PlayerMove.ROCK, PlayerMove.PAPER): GameOutcome.PLAYER_TWO_WIN,
    (PlayerMove.PAPER, PlayerMove.SCISSORS): GameOutcome.PLAYER_TWO_WIN,
    (PlayerMove.SCISSORS, PlayerMove.ROCK): GameOutcome.PLAYER_TWO_WIN,
}


class GameController:
    """The controller class driving (and enforcing) the game rules."""

    _state: Game | None = None
    """Keeps track of the state of the current game."""

    _player_one: Player
    """Instance through which the moves for player one are obtained."""

    _player_two: Player
    """Instance through which the moves for player two are obtained."""

    @property
    def state(self) -> Game:
        assert self._state is not None

        return self._state

    @property
    def player_one(self) -> Player:
        return self._player_one

    @property
    def player_two(self) -> Player:
        return self._player_two

    def __init__(self, player_one: Player, player_two: Player) -> None:
        self._player_one = player_one
        self._player_two = player_two

    def new_game(self) -> Game:
        """
        Start a new game. May be called only if no game has started or if the previous
        game has finished.
        """

        if isinstance(self._player_one, HumanPlayer):
            self._player_one.reset_move()
        if isinstance(self._player_two, HumanPlayer):
            self._player_two.reset_move()

        self._state = Game()

        return self._state

    def resolve_game(self) -> GameOutcome:
        """
        Resolve the current game. Callers need to make sure that all moves have been
        input before calling this.
        """
        assert self._state is not None, "no game has been started"
        assert self._state.outcome is None, "this game has already concluded"
        assert (
            self._state.player_one_move is None
        ), "a move for player one has already been input"
        assert (
            self._state.player_two_move is None
        ), "a move for player two has already been input"

        self._state.player_one_move = self.player_one.get_move()
        self._state.player_two_move = self.player_two.get_move()

        self._state.outcome = _OUTCOMES[
            (self._state.player_one_move, self._state.player_two_move)
        ]

        return self._state.outcome
