package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class RankingKtTest {
    @Test
    fun `순위 테스트`() {
        assertThat(
            ranking(
                5,
                arrayOf(
                    intArrayOf(4, 3),
                    intArrayOf(4, 2),
                    intArrayOf(3, 2),
                    intArrayOf(1, 2),
                    intArrayOf(2, 5)
                )
            )
        ).isEqualTo(2)
    }
}