package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class LockAndKeyKtTest {
    @Test
    fun lockAndKeyTest(){
        assertThat(lockAndKey(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 1)
            ),
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 0, 1)
            )
        )).isEqualTo(true)

        assertThat(lockAndKey(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0),
            ),
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 0, 1)
            )
        )).isEqualTo(true)
    }
}