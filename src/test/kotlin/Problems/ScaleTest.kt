package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class ScaleTest {
    @Test
    fun `오름차순`() {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

        assertThat(
            "ascending",
            equalTo(scale(array))
        )
    }

    @Test
    fun `내림차순`() {
        val array = intArrayOf(8, 7, 6, 5, 4, 3, 2, 1)

        assertThat(
            "descending",
            equalTo(scale(array))
        )
    }

    @Test
    fun `mixed`() {
        val array = intArrayOf(8, 7, 6, 5, 1, 2, 3, 4)

        assertThat(
            "mixed",
            equalTo(scale(array))
        )
    }
}