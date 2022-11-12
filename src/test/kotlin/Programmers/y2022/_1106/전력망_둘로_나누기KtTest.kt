package Programmers.y2022._1106

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class 전력망_둘로_나누기KtTest() {
    @Test
    fun `전력망 둘로 나누기`() {
        assertThat(
            전력망_둘로_나누기(
                9,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(4, 6),
                    intArrayOf(4, 7),
                    intArrayOf(7, 8),
                    intArrayOf(7, 9),
                )
            )
        ).isEqualTo(3)
    }
}