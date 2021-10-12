package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MutualEvaluationTest {
    @Test
    fun `상호평가`() {
        assertThat(
            mutualEvaluation(
                arrayOf(
                    intArrayOf(100, 90, 98, 88, 65),
                    intArrayOf(50, 45, 99, 85, 77),
                    intArrayOf(47, 88, 95, 80, 67),
                    intArrayOf(61, 57, 100, 80, 65),
                    intArrayOf(24, 90, 94, 75, 65),
                )
            ),
            equalTo("FBABD")
        )
    }
}