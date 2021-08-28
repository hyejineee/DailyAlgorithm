package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FailureLateKtTest {
    @Test
    fun `실패율`() {
        assertThat(
            failureLate(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)),
            equalTo(intArrayOf(3, 4, 2, 1, 5))
        )

        assertThat(
            failureLate(4, intArrayOf(4, 4, 4, 4, 4)),
            equalTo(intArrayOf(4, 1, 2, 3))
        )

        assertThat(
            failureLate(5, intArrayOf(4, 4, 4, 4, 4)),
            equalTo(intArrayOf(4, 1, 2, 3, 5))
        )
    }
}