package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class DiskControllerKtTest {

    @Test
    fun diskControllerTest() {
        assertThat(
            diskController(
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(1, 9),
                    intArrayOf(2, 6)
                )
            )
        ).isEqualTo(9)

        assertThat(
            diskController(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(1, 9),
                    intArrayOf(1, 2)
                )
            )
        ).isEqualTo(7)

    }
}