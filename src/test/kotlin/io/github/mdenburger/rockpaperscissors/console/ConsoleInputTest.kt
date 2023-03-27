package io.github.mdenburger.rockpaperscissors.console

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import io.github.mdenburger.rockpaperscissors.domain.Shape.*
import org.junit.jupiter.api.Test

class ConsoleInputTest {

    @Test
    fun `parse shape from well-formed input`() {
        assertThat(parseShapeOrNull("r")).isEqualTo(Rock)
        assertThat(parseShapeOrNull("p")).isEqualTo(Paper)
        assertThat(parseShapeOrNull("s")).isEqualTo(Scissors)
        assertThat(parseShapeOrNull("")).isNull()
    }

    @Test
    fun `parse shape from noisy input`() {
        assertThat(parseShapeOrNull("  r  ")).isEqualTo(Rock)
        assertThat(parseShapeOrNull("P")).isEqualTo(Paper)
        assertThat(parseShapeOrNull("rock")).isEqualTo(Rock)
    }

    @Test
    fun `parse unknown input as null`() {
        assertThat(parseShapeOrNull("q")).isNull()
        assertThat(parseShapeOrNull("\uD83D\uDE03")).isNull()
        assertThat(parseShapeOrNull(" ")).isNull()
    }
}
