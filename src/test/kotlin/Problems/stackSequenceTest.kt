package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class stackSequenceTest {
    @Test
    fun `스택 수열`() {
        assertThat(
            listOf("+", "+", "+", "+", "-", "-", "+", "+", "-", "+", "+", "-", "-", "-", "-", "-"),
            equalTo(stackSequence(8, intArrayOf(4, 3, 6, 8, 7, 5, 2, 1)))
        )
    }
}