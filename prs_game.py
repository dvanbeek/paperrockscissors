"""

    prs_game.py
    -----------

    This module provides the necessary functions to play a Paper Rock Scissors game with the computer. The main function
    that executes a game is called `main_game`

    To execute simply type 'python3 prs_game.py' in the terminal

    Carlos Andres Devia
    21.03.2023

"""

__author__ = "Carlos Andres Devia"


from random import randint


def process_input(choice):
    """
    This function takes the user input and uses it to steer the game logic by means of the list 'choice' and returning a
    boolean variable that decides whether the game continues or not.

    :param choice: this is a list with a single element. The value of this single element is used to pass information
        about the action that the program must take. The element can have 6 possible values:

            2 means that the user played scissors;
            1 means that the user played rock;
            0 means that the user played paper;
            -1 means that the input is invalid and that the program must request another input;
            -2 means that the program must run a test;
            -3 means that the user requested help.

        Non-negative values correspond to valid game moves. Negative values correspond to user inputs that change the
        game state.

    :return: this function returns a boolean value. If the value is False, then the user requested the program to exit,
        if the value is True, then the game continues.
    """

    user_input = input(' ' * 4 + 'Your move: ')

    if user_input.lower() == 'exit':
        return False
    elif (user_input.lower() == 'paper') or (user_input.lower() == 'p'):
        choice[0] = 0
    elif (user_input.lower() == 'rock') or (user_input.lower() == 'r'):
        choice[0] = 1
    elif (user_input.lower() == 'scissors') or (user_input.lower() == 's'):
        choice[0] = 2
    elif user_input.lower() == 'test':
        choice[0] = -2
    elif user_input.lower() == 'help':
        choice[0] = -3
    else:
        choice[0] = -1

    return True


def game_logic(user, computer, current_score):
    """
    This function implements the logic of the game, it takes the user and computer input and calculates the result
    which is then updated in the 'current_score' list.

    :param user: integer between 0 and 2 corresponding to the user input (0 -> Paper, 1 -> Rock, 2 -> Scissors).
    :param computer: integer between 0 and 2 corresponding to the computer input (0 -> Paper, 1 -> Rock, 2 -> Scissors).
    :param current_score: list of three integers with the following interpretation:
        Column 1 -> score of the user.
        Column 2 -> score of the computer.
        Column 3 -> number of ties.
    :return: string with the result, to be printed.
    """
    if user == computer:  # If both made the same choice, it is a tie
        current_score[2] += 1  # update the number of ties
        return 'Tie'
    else:
        if computer == 0:
            computer = 3
        # After this change, the possible values for computer are: 1 -> Rock || 2 -> Scissors || 3 -> Paper
        # And the possible values for user are: 0 -> Paper || 1 -> Rock || 2 -> Scissors
        # Meaning that, if computer - user == 1, then user wins. Otherwise, computer wins
        if computer - user == 1:
            current_score[0] += 1  # update the number of times the user won
            return 'User wins!'
        else:
            current_score[1] += 1  # Update the number of times the computer won
            return 'Computer wins!'


def test_game():
    """
    This function tests the game logic (in particular, the function `game_logic`). It does this by going through
    all the possible combination of inputs and checking that the corresponding output is correct. If the program works
    correctly, it states so. If the program does not work correctly, it returns a string with a message pinpointing the
    possible error.

    :return:
    """
    results_table = [['T', 'U', 'C'], ['C', 'T', 'U'], ['U', 'C', 'T']]
    # Create all possible pair of inputs, according to the 'results_table'
    all_pairs = [[x, y] for x in range(0, len(results_table)) for y in range(0, len(results_table))]
    error_message = None  # The error message starts as a None

    for user, comp in all_pairs:
        partial_results = [0, 0, 0]
        _ = game_logic(user, comp, partial_results)  # we don't care about the resulting string
        winner = results_table[user][comp]  # the winner according to the table
        if winner == 'T':
            if not(partial_results == [0, 0, 1]):
                error_message_1 = f'Error when the user input is {user} and the computer input is {comp}'
                error_message_2 = ' the result should be a tie, but it is not'
                error_message = error_message_1 + error_message_2
                break
        elif winner == 'U':
            if not(partial_results == [1, 0, 0]):
                error_message_1 = f'Error when the user input is {user} and the computer input is {comp}'
                error_message_2 = ' the user should win, but does not'
                error_message = error_message_1 + error_message_2
                break
        elif winner == 'C':
            if not(partial_results == [0, 1, 0]):
                error_message_1 = f'Error when the user input is {user} and the computer input is {comp}'
                error_message_2 = ' the user should win, but does not'
                error_message = error_message_1 + error_message_2
                break

    print('\n')
    if error_message is None:
        print(' ' * 4 + 'The program works correctly')
    else:
        print(' ' * 4 + 'The program does not work correctly. ' + error_message)


def end_game(final_score):
    """ This function takes care of the game end. In this case, it simply prints the final result.

    :param final_score: list with the final score with the following interpretation:
        Column 1 -> score of the user.
        Column 2 -> score of the computer.
        Column 3 -> number of ties.
    :return:
    """

    print('\n\n\n' + '-' * 35 + '\n|')
    print('|' + ' ' * 3 + 'Game ended! \n|')
    print(f'|   Final Score: \n|')
    print(f'|     User wins:     \t {final_score[0]}')
    print(f'|     Computer wins: \t {final_score[1]}')
    print(f'|     Ties:          \t {final_score[2]} \n|')
    print('-' * 35 + '\n\n\n')


def valid_move(user_move, game_score, moves):
    """
    This function computes and prints the game outcome when the input is valid.

    :param user_move: an integer between 0 and 2 representing the user input.
    :param game_score: the current game score. A list with three columns, corresponding to the current score.
    :param moves: a list containing strings for the possible moves. It is used to print the round actions.
    :return:
    """
    # Select an integer from 0 to 2 (or the number of possible moves - 1) with a uniform probability distribution
    computer_move = randint(0, len(moves)-1)
    # Compute the game result
    winner_txt = game_logic(user_move, computer_move, game_score)
    # Print a message to the user
    print(f'    User move = {moves[user_move]}\tComputer move = {moves[computer_move]}    \t{winner_txt}')


def main_game():
    """
    This is the main function that executes a game of Paper Rock Scissors. It consists of variable initialisation
    followed by a while loop that ends when the user decides to exit the game.
    :return:
    """

    # Initialise variables
    moves = ['Paper   ', 'Rock    ', 'Scissors']
    continue_game = True
    user_choice = [0]
    game_score = [0, 0, 0]  # this list will be used to keep the score
    round_counter = 1
    instruction_text = ' ' * 4 + 'Please enter your move (Paper [P], Rock [R], or Scissors [S]). To exit type exit'

    # Print the introduction to the game
    print('\n\n' + '*' * 80 + '\n' + '*' * 80 + '\n\n' + ' ' * 4 + 'Welcome to the Paper Rock Scissors Game\n')
    print(instruction_text + '\n\n')

    # This is the main cycle of the game. The while loop will execute until the user decides to exit the game
    while continue_game:
        print(f'    Round #{round_counter}')  # Print the current round
        continue_game = process_input(user_choice)  # Read and interpret the user input
        if continue_game:  # If the user didn't end the game

            if user_choice[0] >= 0:  # If the user chose a valid move
                round_counter += 1  # Increment the round
                valid_move(user_choice[0], game_score, moves)

            elif user_choice[0] == -2:  # If the input corresponds to a test request
                test_game()

            elif user_choice[0] == -3:  # If the user requested help
                print('\n\n' + instruction_text)

            elif user_choice[0] == -1:  # If the input is invalid
                print(' ' * 4 + 'Invalid input, please try again')

            print('\n\n')
        else:  # If the user ended the game
            end_game(game_score)


if __name__ == '__main__':
    main_game()
