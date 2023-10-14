from collections import defaultdict

from rich import print as rprint
from rich.prompt import Prompt, Confirm

from paperrockscissors.controller.ui import UserInterface, UserInterfaceController
from paperrockscissors.model import GameOutcome, PlayerMove, is_game_finished

_CHOICE_TO_MOVE = {
    "r": PlayerMove.ROCK,
    "p": PlayerMove.PAPER,
    "s": PlayerMove.SCISSORS,
}

_MOVE_TO_TEXT = {
    PlayerMove.ROCK: "[bold green]rock[/bold green]",
    PlayerMove.PAPER: "[bold red]paper[/bold red]",
    PlayerMove.SCISSORS: "[bold yellow]scissors[/bold yellow]",
}

_PLAYER_ONE_TEXT = "[bold blue]Player one[/bold blue]"
_PLAYER_TWO_TEXT = "[bold cyan]Player two[/bold cyan]"


class TextUserInterface(UserInterface):
    _ui_controller: UserInterfaceController | None = None

    @property
    def ui_controller(self) -> UserInterfaceController:
        assert self._ui_controller is not None
        return self._ui_controller

    @ui_controller.setter
    def ui_controller(self, ui_controller: UserInterfaceController) -> None:
        self._ui_controller = ui_controller

    def on_game_start(self) -> None:
        rprint(
            (
                f"Hello, we're playing {_MOVE_TO_TEXT[PlayerMove.PAPER]}-"
                f"{_MOVE_TO_TEXT[PlayerMove.ROCK]}-"
                f"{_MOVE_TO_TEXT[PlayerMove.SCISSORS]}!"
            )
        )

    def game_loop(self) -> bool:
        """
        One iteration of the game. We don't want to start a new game from inside
        the game result event handler because that'd result in unbounded stack growth.
        """
        self.ui_controller.new_game()

        rprint()
        return Confirm.ask("Do you want to play again?")

    def on_new_game(self) -> None:
        rprint()
        rprint("New game started!")

    def on_needs_player_one_input(self) -> None:
        choice = Prompt.ask(
            f"{_PLAYER_ONE_TEXT}, enter your move",
            choices=["p", "r", "s"],
            password=True,
        )
        self.ui_controller.input_move_player_one(_CHOICE_TO_MOVE[choice])

    def on_needs_player_two_input(self) -> None:
        choice = Prompt.ask(
            f"{_PLAYER_TWO_TEXT}, enter your move",
            choices=["p", "r", "s"],
            password=True,
        )
        self.ui_controller.input_move_player_two(_CHOICE_TO_MOVE[choice])

    def on_game_result(self) -> None:
        game = self.ui_controller.game_history[-1]
        assert is_game_finished(game), "game should be finished"
        one_move = game.player_one_move
        two_move = game.player_two_move

        rprint("Game results:")
        rprint(f"\t{_PLAYER_ONE_TEXT} chose {_MOVE_TO_TEXT[one_move]}!")
        rprint(f"\t{_PLAYER_TWO_TEXT} chose {_MOVE_TO_TEXT[two_move]}!")

        match game.outcome:
            case GameOutcome.PLAYER_ONE_WIN:
                rprint(f"{_PLAYER_ONE_TEXT} has won!")
            case GameOutcome.PLAYER_TWO_WIN:
                rprint(f"{_PLAYER_TWO_TEXT} has won!")
            case GameOutcome.TIE:
                rprint("The game is a [bold white]tie[/bold white]!")

    def on_print_stats(self) -> None:
        outcomes: defaultdict[GameOutcome, int] = defaultdict(lambda: 0)
        one_choices: defaultdict[PlayerMove, int] = defaultdict(lambda: 0)
        two_choices: defaultdict[PlayerMove, int] = defaultdict(lambda: 0)
        for game in self.ui_controller.game_history:
            assert is_game_finished(game), "game should be finished"

            outcomes[game.outcome] += 1
            one_choices[game.player_one_move] += 1
            two_choices[game.player_two_move] += 1

        rprint()
        rprint("Thank you for playing! Some statistics:")
        rprint()
        rprint(f"{_PLAYER_ONE_TEXT} choices:")
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.PAPER]}: {one_choices[PlayerMove.PAPER]} times"
        )
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.ROCK]}: {one_choices[PlayerMove.ROCK]} times"
        )
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.SCISSORS]}: {one_choices[PlayerMove.SCISSORS]} times"
        )
        rprint(f"{_PLAYER_TWO_TEXT} choices:")
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.PAPER]}: {two_choices[PlayerMove.PAPER]} times"
        )
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.ROCK]}: {two_choices[PlayerMove.ROCK]} times"
        )
        rprint(
            f"\t{_MOVE_TO_TEXT[PlayerMove.SCISSORS]}: {two_choices[PlayerMove.SCISSORS]} times"
        )
        rprint()
        rprint("Game outcomes:")
        rprint(f"\t{_PLAYER_ONE_TEXT} won {outcomes[GameOutcome.PLAYER_ONE_WIN]} games")
        rprint(f"\t{_PLAYER_TWO_TEXT} won {outcomes[GameOutcome.PLAYER_TWO_WIN]} games")
        rprint(f"\t{outcomes[GameOutcome.TIE]} games resulted in a tie")
        rprint()
