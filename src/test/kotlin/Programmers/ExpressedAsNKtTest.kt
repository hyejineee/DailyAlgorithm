package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class ExpressedAsNKtTest{
    @Test
    fun expressedAsNTest() {
        assertThat(
            expressedAsN(5, 12)
        ).isEqualTo(4)

        assertThat(
            expressedAsN(2, 11)
        ).isEqualTo(3)
    }
}