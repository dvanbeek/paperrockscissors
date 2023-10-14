from abc import ABC

from paperrockscissors.model import Game, PlayerMove
from paperrockscissors.controller.game import GameController, Player, HumanPlayer


class UserInterface(ABC):
    """
    Base class for user interfaces. This is so we can more easily unit test the user
    interface logic.
    """

    def on_game_start(self) -> None:
        """The game was started."""
        pass

    def on_new_game(self) -> None:
        """A new game was started."""
        pass

    def on_needs_player_one_input(self) -> None:
        """(Human) player one input is required."""
        pass

    def on_needs_player_two_input(self) -> None:
        """(Human) player two input is required."""
        pass

    def on_player_input(self) -> None:
        """A player input a move."""
        pass

    def on_game_result(self) -> None:
        """A game was finished and has a result."""
        pass

    def on_print_stats(self) -> None:
        """The user wants to see gameplay statistics."""
        pass


class UserInterfaceController:
    """
    Main class driving the user interface of the game. Written in a way that there
    could conceivably be multiple UI options -- although there is of course only the
    TUI option now to not (further) complicate this.
    """

    user_interface: UserInterface
    """The user interface being driven by this controller."""

    _game_history: list[Game]

    _cur_game: Game | None = None

    _game_controller: GameController

    @property
    def game_history(self) -> list[Game]:
        """History of games being played during this session."""
        return self._game_history

    @property
    def cur_game(self) -> Game:
        """Return the current game."""
        assert self._cur_game is not None, "no game in progress"

        return self._cur_game

    def __init__(
        self, user_interface: UserInterface, player_one: Player, player_two: Player
    ) -> None:
        self.user_interface = user_interface
        self._game_history = []
        self._game_controller = GameController(player_one, player_two)

    def start(self):
        """Called when the game is started."""
        self.user_interface.on_game_start()

    def new_game(self):
        """Start a new game."""
        self._cur_game = self._game_controller.new_game()

        self.user_interface.on_new_game()

        has_human = False
        if isinstance(self._game_controller.player_one, HumanPlayer):
            has_human = True
            self.user_interface.on_needs_player_one_input()
        if isinstance(self._game_controller.player_two, HumanPlayer):
            has_human = True
            self.user_interface.on_needs_player_two_input()
        # If there's no human involved we want to show results immediately.
        if not has_human:
            self._resolve_game()

    def input_move_player_one(self, move: PlayerMove) -> None:
        """
        Input a move for player one. Will throw if player one is not a human player.
        """
        assert isinstance(
            self._game_controller.player_one, HumanPlayer
        ), "player one must be a human to input moves"

        self._game_controller.player_one.input_move(move)

        self.user_interface.on_player_input()
        if self._all_moved():
            self._resolve_game()

    def input_move_player_two(self, move: PlayerMove) -> None:
        """
        Input a move for player two. Will throw if player one is not a human player.
        """
        assert isinstance(
            self._game_controller.player_two, HumanPlayer
        ), "player two must be a human to input moves"

        self._game_controller.player_two.input_move(move)

        self.user_interface.on_player_input()
        if self._all_moved():
            self._resolve_game()

    def _all_moved(self) -> bool:
        """Check if all human players have input a move."""
        return not len(
            [
                p
                for p in (
                    self._game_controller.player_one,
                    self._game_controller.player_two,
                )
                if isinstance(p, HumanPlayer) and p.move is None
            ]
        )

    def _resolve_game(self) -> None:
        """Resolve the current game."""
        assert self._cur_game is not None, "no game started yet"
        self._game_controller.resolve_game()
        self._game_history.append(self._cur_game)
        self._cur_game = None

        self.user_interface.on_game_result()

    def quit(self) -> None:
        """User has requested to quit."""
        self.user_interface.on_print_stats()
