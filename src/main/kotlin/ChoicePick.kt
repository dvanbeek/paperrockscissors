sealed interface ChoicePick {
    data class AChoice(val choice: Choice) : ChoicePick
    data object Exit : ChoicePick {
        const val DISPLAY_NAME = "exit"
    }
}
