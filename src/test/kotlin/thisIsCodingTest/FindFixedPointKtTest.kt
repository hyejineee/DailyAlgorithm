package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class FindFixedPointKtTest {
    @Test
    fun findFixedPointTest(){
        assertThat(findFixedPoint(intArrayOf(-15,-6,1,3,7))).isEqualTo(3)
        assertThat(findFixedPoint(intArrayOf(-15,-4,2,8,9,13,15))).isEqualTo(2)
        assertThat(findFixedPoint(intArrayOf(-15,-4,3,8,9,13,15))).isEqualTo(-1)
    }
}