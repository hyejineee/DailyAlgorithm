package oliveYong

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class Problem1Test {
    @Test
    fun `ㄱㅣ지국 영역 구하기`() {
        assertThat(
            problem1(
                intArrayOf(3, 4),
                intArrayOf(3, 5),
                intArrayOf(2, 3),
                intArrayOf(12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15)
            ),
            equalTo(28)
        )
    }
}