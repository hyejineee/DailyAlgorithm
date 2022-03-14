package Programmers

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TriangularSnailTest {
    @Test
    fun `삼각 달팽이`() {
//        assertThat(
//            triangularSnail(4),
//            equalTo(intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7))
//        )
//
//        assertThat(
//            triangularSnail(5),
//            equalTo(intArrayOf(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9))
//        )
//
        assertThat(
            triangularSnail(6),
            equalTo(intArrayOf(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11))
        )

//        assertThat(
//            triangularSnail(10),
//            equalTo(intArrayOf())
//        )
    }
}