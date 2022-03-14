package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class LottoHighsAndLowsKtTest {
    @Test
    fun lottoHighsAndLowsTest() {
        assertThat(lottoHighsAndLows(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19))).isEqualTo(
            intArrayOf(3, 5)
        )

        assertThat(lottoHighsAndLows(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25))).isEqualTo(
            intArrayOf(1, 6)
        )

        assertThat(lottoHighsAndLows(intArrayOf(45, 4, 35, 20, 3, 9), intArrayOf(20, 9, 3, 45, 4, 35))).isEqualTo(
            intArrayOf(1, 6)
        )

        assertThat(lottoHighsAndLows(intArrayOf(1,1,1,1,1,1), intArrayOf(20, 9, 3, 45, 4, 35))).isEqualTo(
            intArrayOf(6, 6)
        )
    }
}