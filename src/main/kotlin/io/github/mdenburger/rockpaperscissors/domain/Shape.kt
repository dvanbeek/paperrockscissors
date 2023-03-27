package io.github.mdenburger.rockpaperscissors.domain

enum class Shape {
    Rock, Paper, Scissors;

    fun beats(other: Shape): Boolean =
        when (this) {
            Rock -> other == Scissors
            Paper -> other == Rock
            Scissors -> other == Paper
        }

}
