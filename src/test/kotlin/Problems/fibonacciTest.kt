package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class fibonacciTest {
    @Test
    fun `피보나치 수열`() {
        assertThat(
            fibonacci(3),
            equalTo(intArrayOf(1, 2))
        )
    }
}