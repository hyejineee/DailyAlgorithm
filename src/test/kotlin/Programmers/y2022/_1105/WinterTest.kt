package Programmers.y2022._1105

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Assert.*
import org.junit.Test

class WinterTest {
    val solutaions = Winter()

    @Test
    fun solution01Test() {
        assertThat(solutaions.solution1("aabbbc")).isEqualTo("a*b*c")
    }

    @Test
    fun solution02Test() {
        assertThat(
            solutaions.solution2(
                6,
                intArrayOf(6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5),
                intArrayOf(3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2)
            )
        ).isEqualTo(7)
    }

    @Test
    fun solution03Test() {
        assertThat(solutaions.solution3(arrayOf("..XXX", "..XXX", "...XX", "X....", "XXX.."))).isEqualTo(5)
    }
}