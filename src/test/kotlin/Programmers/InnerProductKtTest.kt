package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class InnerProductKtTest {
    @Test
    fun innerProductTest() {
        assertThat(innerProduct(intArrayOf(1, 2, 3, 4), intArrayOf(-3, -1, 0, 2))).isEqualTo(3)
    }
}