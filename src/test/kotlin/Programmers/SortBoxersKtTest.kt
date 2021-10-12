package Programmers


import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SortBoxersKtTest {
    @Test
    fun `복서 정렬하기`() {
//        assertThat(
//            sortBoxer(intArrayOf(145, 92, 86), arrayOf("NLW", "WNL", "LWN")),
//            equalTo(intArrayOf(2, 3, 1))
//        )

        assertThat(
            sortBoxer(intArrayOf(50, 82, 75, 120), arrayOf("NLWL", "WNLL", "LWNW", "WWLN")),
            equalTo(intArrayOf(3, 4, 1, 2))
        )

        assertThat(
            sortBoxer(intArrayOf(10, 10, 10), arrayOf("NNN", "NLN", "NWN")),
            equalTo(intArrayOf(3, 1, 2))
        )
    }
}