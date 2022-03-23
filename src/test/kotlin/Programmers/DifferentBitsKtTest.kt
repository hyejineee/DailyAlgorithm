package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class DifferentBitsKtTest {
    @Test
    fun differentBitsTest(){
        assertThat(differentBits(longArrayOf(2,7))).isEqualTo(longArrayOf(3,11))
    }
}