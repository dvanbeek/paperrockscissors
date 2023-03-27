package io.github.mdenburger.rockpaperscissors.domain

import io.github.mdenburger.rockpaperscissors.domain.Shape.*
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ShapeTest {

    @Test
    fun `each shape beats one other shape`() {
        assertTrue(Rock.beats(Scissors))
        assertTrue(Paper.beats(Rock))
        assertTrue(Scissors.beats(Paper))
    }

    @Test
    fun `shapes don't beat themselves`() {
        for (shape in Shape.values()) {
            assertFalse(shape.beats(shape))
        }
    }

    @Test
    fun `each shape does not beat one other shape`() {
        assertFalse(Rock.beats(Paper))
        assertFalse(Paper.beats(Scissors))
        assertFalse(Scissors.beats(Rock))
    }
}
