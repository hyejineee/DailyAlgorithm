package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class InOutTest {
    @Test
    fun `입실 퇴실`() {
//        assertThat(
//            inOut(intArrayOf(1, 4, 2, 3), intArrayOf(2, 1, 3, 4)),
//            equalTo(intArrayOf(2, 2, 1, 3))
//        )


        assertThat(
            inOut(intArrayOf(1, 3, 2), intArrayOf(1, 2, 3)),
            equalTo(intArrayOf(0, 1, 1))
        )
    }
}