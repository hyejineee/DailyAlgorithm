package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class GoldMineKtTest {
    @Test
    fun goldMineTest(){
        assertThat(goldMine(3,4, intArrayOf(1,3,3,2,2,1,4,1,0,6,4,7))).isEqualTo(19)
        assertThat(goldMine(4,4, intArrayOf(1,3,1,5,2,2,4,1,5,0,2,3,0,6,1,2))).isEqualTo(16)
    }
}