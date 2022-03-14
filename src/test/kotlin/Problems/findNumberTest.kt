package Problems

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class findNumberTest {

    @Test
    fun `수 찾기`() {
        assertThat(
            intArrayOf(1, 1, 0, 0, 1),
            equalTo(
                findNumber(intArrayOf(4, 1, 5, 2, 3), intArrayOf(1, 3, 7, 9, 5))
            )
        )
    }
}