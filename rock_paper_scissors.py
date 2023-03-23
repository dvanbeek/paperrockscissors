import random

# Defines a function to play rock-paper-scissors
def rock_paper_scissors():
    options = ["paper", "rock", "scissors"]

    print("\nWelcome to the game of rock-paper-scissors!")
    
     # Keeps asking for user input until it is valid
    while True:
        user_choice = input("\nChoose paper, rock, or scissors: ").lower()
        if user_choice in options:
            break  # Exits the loop if the input is valid
        print("\nHey! That's invalid input! Go again.")

    computer_choice = random.choice(options)

    print(f"\nYou chose {user_choice}, and the computer chose {computer_choice}.\n")

    # Determine the winner according to the set logic
    if user_choice == computer_choice:
        print("It's a tie!")
        return "tie"
    elif (user_choice == "rock" and computer_choice == "scissors") or (user_choice == "paper" and computer_choice == "rock") or (user_choice == "scissors" and computer_choice == "paper"):
        print("You won!")
        return "win"
    else:
        print("The computer won!")
        return "lose"

# Defines a function to print the game summary
def summary(games_won, games_lost, games_tied):
    total_games = games_won + games_lost + games_tied
    print(f"\nGames played: {total_games}")
    print(f"Games won: {games_won}")
    print(f"Games lost: {games_lost}")
    print(f"Games tied: {games_tied}")

# Initializes counters for games won, lost, and tied
games_won = 0
games_lost = 0
games_tied = 0

# The game loop itself
while True:
    result = rock_paper_scissors()
    if result == "win":
        games_won += 1
    elif result == "lose":
        games_lost += 1
    else:
        games_tied += 1

    choice = input("\nThe game goes on, unless you say 'stop'.\n\n")
    if choice.lower() == "stop":  # Continues the loop in any other case
        summary(games_won, games_lost, games_tied)
        break
