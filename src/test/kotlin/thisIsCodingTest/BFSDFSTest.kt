package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class BFSDFSTest {
    val methods = BFSDFS()

    @Test
    fun freezeDrinksTest() {
        assertThat(
            methods.freezeDrinks(
                arrayOf(
                    intArrayOf(0, 0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0),
                )
            )
        ).isEqualTo(3)
    }

    @Test
    fun mazeEscapeTest() {
        assertThat(
            methods.mazeEscape(
                5, 6,
                arrayOf(
                    intArrayOf(1, 0, 1, 0, 1, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                )
            )
        ).isEqualTo(10)
    }
}