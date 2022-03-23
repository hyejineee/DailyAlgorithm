package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class BoardingGateKtTest {
    @Test
    fun boardingGateTest() {
        assertThat(boardingGate(4, 3, intArrayOf(4, 1, 1))).isEqualTo(2)
        assertThat(boardingGate(4, 6, intArrayOf(2, 2, 3, 3, 4, 4))).isEqualTo(3)
    }
}