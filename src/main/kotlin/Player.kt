interface Player {
    val displayName: String

    fun pickChoice(gui: Gui): ChoicePick

    data class Cpu(override val displayName: String = "cpu") : Player {
        override fun pickChoice(gui: Gui): ChoicePick = ChoicePick.AChoice(Choice.entries.random())
    }

    data class Human(override val displayName: String = "user") : Player {
        override fun pickChoice(gui: Gui): ChoicePick = when (val userInput = gui.awaitUserChoicePick()) {
            ChoicePick.Exit -> ChoicePick.Exit
            is ChoicePick.AChoice -> ChoicePick.AChoice(userInput.choice)
        }
    }
}

/**
 * Utility to prevent repeating the ChoicePick matching.
 * Extension function prevents override by interface inheritors.
 */
fun Player.pickChoiceThrowing(gui: Gui): Choice = when (val choicePick = pickChoice(gui)) {
    is ChoicePick.AChoice -> choicePick.choice
    is ChoicePick.Exit -> throw ExitPickChoice
}
