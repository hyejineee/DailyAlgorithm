package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MaxAndMinKtTest {
    @Test
    fun `최댓값과 최솟값`() {
        assertThat(
            maxAndMin("-1 -2 -3 -4"),
            equalTo("-4 -1")
        )
    }
}