package io.github.mdenburger.rockpaperscissors.domain

enum class RoundResult {
    Win, Loss, Tie;

    fun opposite(): RoundResult =
        when (this) {
            Win -> Loss
            Loss -> Win
            Tie -> Tie
        }
}
