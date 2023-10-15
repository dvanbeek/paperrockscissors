import click

from paperrockscissors.controller.game import HumanPlayer, Player, RandomComputerPlayer
from paperrockscissors.controller.ui import UserInterfaceController
from paperrockscissors.view.text import TextUserInterface


def _create_player(choice: str) -> Player:
    assert choice == "human" or choice == "cpu"

    match choice:
        case "human":
            return HumanPlayer()
        case "cpu":
            return RandomComputerPlayer()


@click.command
@click.option("--player-one-type", type=click.Choice(["human", "cpu"]), default="human")
@click.option("--player-two-type", type=click.Choice(["human", "cpu"]), default="cpu")
def main(player_one_type: str, player_two_type: str):
    text_ui = TextUserInterface()
    player_one = _create_player(player_one_type)
    player_two = _create_player(player_two_type)
    ui_controller = UserInterfaceController(text_ui, player_one, player_two)
    # Bit annoying, but have to break the dependency loop somewhere
    text_ui.ui_controller = ui_controller

    ui_controller.start()

    while text_ui.game_loop():
        pass

    ui_controller.quit()
