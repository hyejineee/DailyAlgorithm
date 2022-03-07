package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


class ShortestPathTest {

    val method = ShortestPath()

    @Test
    fun futureCityTest() {
        assertThat(
            method.futureCity(
                5, 7,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 4),
                    intArrayOf(3, 4),
                    intArrayOf(3, 5),
                    intArrayOf(4, 5),
                ),
                4, 5
            )
        ).isEqualTo(3)
    }

    @Test
    fun telegramTest() {
        assertThat(
            method.telegram(
                3,
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(1, 3, 2),
                ), 1
            )
        ).isEqualTo("2 4")
    }
}