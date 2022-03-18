package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class ChooseBowlingBallKtTest {
    @Test
    fun chooseBowlingBallTest(){
        assertThat(chooseBowlingBall(5, intArrayOf(1,3,2,3,2))).isEqualTo(8)
        assertThat(chooseBowlingBall(8, intArrayOf(1,5,4,3,2,4,5,2))).isEqualTo(25)

    }
}