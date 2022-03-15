package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class CountTheNumberKtTest {
    @Test
    fun countTheNumberTest() {
        assertThat(countTheNumber(intArrayOf(1, 1, 2, 2, 2, 2, 3), 4)).isEqualTo(-1)
        assertThat(countTheNumber(intArrayOf(1, 1, 2, 2, 2, 2, 3), 2)).isEqualTo(4)
    }
}