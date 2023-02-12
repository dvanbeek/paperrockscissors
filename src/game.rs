use std::fmt::Display;
use std::io::{ErrorKind};

use rand_derive2::RandGen;

/// Represents a game session, supplying an opponent
pub struct Game<T: Opponent> {
    pub opponent: T,
    pub lost: u32,
    pub draw: u32,
    pub win: u32,
}
/// A single move for standard RockPaperScissors
#[derive(PartialEq, Eq, Debug, RandGen, Clone)]
pub enum GameMove {
    Rock,
    Paper,
    Scissors,
}

/// A result of a round of rps.
#[derive(PartialEq, Eq, Debug)]
pub enum GameResult {
    Win,
    Lose,
    Draw,
}

/// A trait for opponents to implement. Interesting extension would be
/// give the opponent access to the Game struct, possibly to the current player's
/// history.
pub trait Opponent {
    fn pick_move(&mut self) -> GameMove;
}
/// Represents a session of rock-paper-scissors
impl<T: Opponent> Game<T> {
    /// Initialize a session. Example:
    /// ```
    /// use hartwig_test::game::*;
    /// use hartwig_test::opponents::*;
    /// let g = Game::new(RandomOpponent::default());
    /// ```
    pub fn new(opponent: T) -> Self {
        Game {
            opponent,
            lost: 0,
            draw: 0,
            win: 0,
        }
    }

    /// Play one round, returns the result, also records the win/lose/draw
    /// ```
    /// use hartwig_test::game::*;
    /// use hartwig_test::opponents::*;
    /// let mut g = Game::new(RandomOpponent::default());
    /// let result: (_,GameResult) = g.record_round(&GameMove::Rock);
    ///
    /// ```
    pub fn record_round(&mut self, my_move: &GameMove) -> (GameMove, GameResult) {
        let opponent_move = self.opponent.pick_move();
        let result = Self::game_move(my_move, &opponent_move);
        match result {
            GameResult::Win => self.win += 1,
            GameResult::Lose => self.lost += 1,
            GameResult::Draw => self.draw += 1,
        }
        (opponent_move, result)
    }

    fn game_move(my_move: &GameMove, other_move: &GameMove) -> GameResult {
        match (my_move, other_move) {
            (GameMove::Rock, GameMove::Rock) => GameResult::Draw,
            (GameMove::Rock, GameMove::Paper) => GameResult::Lose,
            (GameMove::Rock, GameMove::Scissors) => GameResult::Win,
            (GameMove::Paper, GameMove::Rock) => GameResult::Win,
            (GameMove::Paper, GameMove::Paper) => GameResult::Draw,
            (GameMove::Paper, GameMove::Scissors) => GameResult::Lose,
            (GameMove::Scissors, GameMove::Rock) => GameResult::Lose,
            (GameMove::Scissors, GameMove::Paper) => GameResult::Win,
            (GameMove::Scissors, GameMove::Scissors) => GameResult::Draw,
        }
    }
}

impl Display for GameMove {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            GameMove::Rock => f.write_str("Rock"),
            GameMove::Paper => f.write_str("Paper"),
            GameMove::Scissors => f.write_str("Scissors"),
        }
    }
}

impl Display for GameResult {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            GameResult::Win => f.write_str("Win"),
            GameResult::Lose => f.write_str("Lose"),
            GameResult::Draw => f.write_str("Draw"),
        }
    }
}

impl TryFrom<&String> for GameMove {
    type Error = std::io::Error;

    fn try_from(input: &String) -> std::result::Result<Self, Self::Error> {
        match input.trim() {
            "r" => Ok(GameMove::Rock),
            "p" => Ok(GameMove::Paper),
            "s" => Ok(GameMove::Scissors),
            _ => Err(std::io::Error::new(ErrorKind::InvalidData,"invalid move, closing"))
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::{
        game::{Game, GameMove, GameResult},
        opponents::test::TestOpponent,
    };

    #[test]
    fn test_parser() {
        assert_eq!(GameMove::Rock, GameMove::try_from(&"r".to_owned()).unwrap());
        assert_eq!(
            GameMove::Rock,
            GameMove::try_from(&"   r   ".to_owned()).unwrap()
        ); // Test trimming whitespace
        assert!(GameMove::try_from(&"😀".to_owned()).is_err()); // Test weird input
    }

    #[test]
    fn basic_result_sanity() {
        let mut game = Game::new(TestOpponent::new(vec![
            GameMove::Rock,
            GameMove::Scissors,
            GameMove::Paper,
        ]));
        assert_eq!(
            (GameMove::Rock, GameResult::Win),
            game.record_round(&GameMove::Paper)
        ); // opponent will play rock
        assert_eq!(
            (GameMove::Scissors, GameResult::Draw),
            game.record_round(&GameMove::Scissors)
        ); // opponent will play scissors
        assert_eq!(
            (GameMove::Paper, GameResult::Lose),
            game.record_round(&GameMove::Rock)
        ); // opponent will play paper
        assert_eq!(1, game.win);
        assert_eq!(1, game.lost);
        assert_eq!(1, game.draw);
    }
}
