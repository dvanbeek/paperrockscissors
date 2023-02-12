mod game;

use std::io::{stdin, stdout, Result, Write};

use crate::{
    game::{Game, GameMove},
    opponents::RandomOpponent,
};
mod opponents;

fn main() -> Result<()> {
    let opponent = RandomOpponent::default();
    let mut game = Game::new(opponent);
    loop {
        print!("(r,p,s), anything else to exit>");
        stdout().flush()?;
        let my_move = GameMove::try_from(&read_line()?);
        if let Ok(m) = my_move {
            let (opponent_move, result) = game.record_round(&m);
            println!(
                "You played: {} opponent played: {}, result: {}",
                &m, &opponent_move, result
            );
        } else {
            break;
        }
    }
    println!(
        "Results: win: {} draw: {} lost: {}",
        game.win, game.draw, game.lost
    );
    Ok(())
}

fn read_line() -> Result<String> {
    let mut buffer = String::new();
    stdin().read_line(&mut buffer)?;
    Ok(buffer)
}
