use criterion::{criterion_group, criterion_main, Criterion};

use hartwig_test::{
    game::{Game, GameMove},
    opponents::{RandomOpponent, test::TestOpponent},
};
use itertools::repeat_n;

fn bench_gamerun_random(c: &mut Criterion) {
    let mut game = Game::new(RandomOpponent::default());

    let input: Vec<GameMove> = repeat_n((), 1000)
        .map(|_| GameMove::generate_random())
        .collect();

    c.bench_function("running games", |b| {
        b.iter(|| {
            for m in &input {
                game.record_round(&m);
            }
        })
    });
}

fn bench_gamerun_deterministic(c: &mut Criterion) {

    let input: Vec<GameMove> = repeat_n((), 1000)
        .map(|_| GameMove::generate_random())
        .collect();

    let opponent: Vec<GameMove> = repeat_n((), 1000)
        .map(|_| GameMove::generate_random())
        .collect();

    let mut game = Game::new(TestOpponent::new(opponent));

    c.bench_function("running games", |b| {
        b.iter(|| {
            for m in &input {
                game.record_round(&m);
            }
        })
    });
}

criterion_group!(rps, bench_gamerun_random,bench_gamerun_deterministic);
criterion_main!(rps);
