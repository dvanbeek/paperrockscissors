use crate::game::{GameMove, Opponent};
/// The only 'real' opponent: Will make a random move every time
pub struct RandomOpponent;

impl Default for RandomOpponent {
    fn default() -> Self {
        RandomOpponent
    }
}

impl Opponent for RandomOpponent {
    fn pick_move(&mut self) -> GameMove {
        GameMove::generate_random()
    }
}

pub mod test {
    use std::iter::repeat;

    use crate::game::{GameMove, Opponent};

    /// A test opponent. Takes a vec of moves, and will play these moves, in order,
    /// forever
    pub struct TestOpponent {
        moves: Box<dyn Iterator<Item = GameMove>>,
    }

    impl TestOpponent {
        // Create an eternally looping stream over these moves
        #![allow(dead_code)]
        pub fn new(moves: Vec<GameMove>) -> TestOpponent {
            let a = repeat(moves).flatten();
            TestOpponent { moves: Box::new(a) }
        }
    }

    impl Opponent for TestOpponent {
        fn pick_move(&mut self) -> GameMove {
            self.moves.next().unwrap()
        }
    }
}
