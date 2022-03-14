package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class NetworkKtTest {

    @Test
    fun `network problem test`() {
        assertThat(
            network(3, arrayOf(
                intArrayOf(1,1,0),
                intArrayOf(1,1,1),
                intArrayOf(0,1,1)
            ))
        ).isEqualTo(1)

        assertThat(
            network(3, arrayOf(
                intArrayOf(1,1,0),
                intArrayOf(1,1,0),
                intArrayOf(0,0,1)
            ))
        ).isEqualTo(2)
    }


}