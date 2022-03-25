package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class MukbangLiveKtTest {
    @Test
    fun mukbangLiveTest(){
        assertThat(mukbangLive(intArrayOf(3,1,2), 5)).isEqualTo(1)
//        assertThat(mukbangLive(intArrayOf(3,1,1,1,1,9,4,5,6), 10)).isEqualTo(6)
    }
}