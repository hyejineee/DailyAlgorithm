package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class NLCMKtTest {
    @Test
    fun `n개의 제곱근 구하기`() {
        assertThat(
            nLCM(intArrayOf(2, 6, 8, 14)),
            equalTo(168)
        )

        assertThat(
            nLCM(intArrayOf(1, 2, 3)),
            equalTo(6)
        )
    }

    @Test
    fun `약수 구하기`() {
        assertThat(
            aliquot(24),
            equalTo(listOf(1, 2, 3, 4, 6, 8, 12, 24))
        )
    }
}