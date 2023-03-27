package io.github.mdenburger.rockpaperscissors.domain

fun playRound(me: Shape, opponent: Shape): RoundResult =
    if (me.beats(opponent)) {
        RoundResult.Win
    } else if (opponent.beats(me)) {
        RoundResult.Loss
    } else {
        RoundResult.Tie
    }
