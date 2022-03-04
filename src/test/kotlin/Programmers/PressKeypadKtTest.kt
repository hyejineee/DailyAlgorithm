package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class PressKeypadKtTest{
    @Test
    fun pressKeypadTest(){
//        assertThat(pressKeypad(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right")).isEqualTo("LRLLLRLLRRL")
        assertThat(pressKeypad(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")).isEqualTo("LRLLRRLLLRR")
    }
}