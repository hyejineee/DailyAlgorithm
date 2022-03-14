package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class MinRectangleKtTest{
    @Test
    fun minRectangleTest(){
        assertThat(minRectangle(arrayOf(
            intArrayOf(10, 7),
            intArrayOf(12, 3),
            intArrayOf(8, 15),
            intArrayOf(14, 7),
            intArrayOf(5, 15),
        ))).isEqualTo(120)
    }
}