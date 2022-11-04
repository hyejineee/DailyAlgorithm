package Programmers.y2022._1104

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Assert.*
import org.junit.Test

class 할인행사KtTest() {
    @Test
    fun `할인행사`() {
        assertThat(
            할인행사(
                arrayOf("banana", "apple", "rice", "pork", "pot"),
                intArrayOf(3, 2, 2, 2, 1),
                arrayOf(
                    "chicken",
                    "apple",
                    "apple",
                    "banana",
                    "rice",
                    "apple",
                    "pork",
                    "banana",
                    "pork",
                    "rice",
                    "pot",
                    "banana",
                    "apple",
                    "banana",
                )
            )
        ).isEqualTo(3)
    }
}