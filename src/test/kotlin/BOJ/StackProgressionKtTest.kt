package BOJ

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StackProgressionKtTest {
    @Test
    fun `스택수열`() {
        assertThat(
            stackProgression(intArrayOf(4, 3, 6, 8, 7, 5, 2, 1)),
            equalTo(
                "+\n+\n+\n+\n-\n-\n+\n+\n-\n+\n+\n-\n-\n-\n-\n-"
            )
        )

        assertThat(
            stackProgression(intArrayOf(1, 2, 5, 3, 4)),
            equalTo(
                "NO"
            )
        )

        assertThat(
            stackProgression(intArrayOf(1)),
            equalTo(
                mutableListOf("+", "-")
            )
        )

        assertThat(
            stackProgression(intArrayOf(3, 2, 1)),
            equalTo(
                "+\n+\n+\n-\n-\n-"
            )
        )

        assertThat(
            stackProgression(intArrayOf(3)),
            equalTo(
                "+\n+\n+\n-"
            )
        )

    }
}