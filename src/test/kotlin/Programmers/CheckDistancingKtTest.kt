package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class CheckDistancingKtTest {

    @Test
    fun checkDistancingTest() {
        assertThat(
            checkWaitingRoom(
                arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX")
            )
        ).isEqualTo(1)

        assertThat(
            checkWaitingRoom(
                arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            )
        ).isEqualTo(0)

        assertThat(
            checkDistancing(
                arrayOf(
                    arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
                    arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
                    arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
                    arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
                    arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
                )
            )
        ).isEqualTo(intArrayOf(1, 0, 1, 1, 1))
    }

}