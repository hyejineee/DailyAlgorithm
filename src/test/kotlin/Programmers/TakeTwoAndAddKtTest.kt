package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TakeTwoAndAddKtTest {
    @Test
    fun `두 개 뽑아서 더하기`() {
        assertThat(
            takeTwoAndAdd(intArrayOf(2, 1, 3, 4, 1)),
            equalTo(intArrayOf(2, 3, 4, 5, 6, 7))
        )

        assertThat(
            takeTwoAndAdd(intArrayOf(5, 0, 2, 7)),
            equalTo(intArrayOf(2, 5, 7, 9, 12))
        )
    }
}