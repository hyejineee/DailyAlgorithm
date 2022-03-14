package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TargetNumberKtTest {
    @Test
    fun `타겟 넘버`() {
        assertThat(
            targetNumber(intArrayOf(1, 1, 1, 1, 1), 3),
            equalTo(5)
        )

        assertThat(
            targetNumber(intArrayOf(1, 2), 1),
            equalTo(1)
        )
    }
}