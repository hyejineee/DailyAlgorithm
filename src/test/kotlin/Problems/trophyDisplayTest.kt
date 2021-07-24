package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class trophyDisplayTest {
    @Test
    fun `트로피 진열`() {

        assertThat(
            trophyDisplay(intArrayOf(1, 2, 3, 4, 5)),
            equalTo(intArrayOf(5, 1))
        )

        assertThat(
            trophyDisplay(intArrayOf(1)),
            equalTo(intArrayOf(1, 1))
        )

        assertThat(
            trophyDisplay(intArrayOf(1, 1, 2, 3, 4, 5, 2, 3, 4, 5)),
            equalTo(intArrayOf(7, 2))
        )
    }
}