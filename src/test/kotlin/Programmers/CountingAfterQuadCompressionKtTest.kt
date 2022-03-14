package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CountingAfterQuadCompressionKtTest {
    @Test
    fun `쿼드압축 후 개수 세기`() {
        assertThat(
            countingAfterQuadCompression(
                arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(1, 1, 1, 1),
                )
            ),
            equalTo(intArrayOf(4, 9))
        )
    }

    @Test
    fun `압축여부확인`() {
        assertThat(
            compressionCheckBy(mutableListOf(0, 0, 1, 1), 0),
            equalTo(false)
        )

        assertThat(
            compressionCheckBy(mutableListOf(0, 0, 0, 0), 0),
            equalTo(true)
        )

        assertThat(
            compressionCheckBy(mutableListOf(1, 1, 1, 1), 1),
            equalTo(true)
        )
    }
}