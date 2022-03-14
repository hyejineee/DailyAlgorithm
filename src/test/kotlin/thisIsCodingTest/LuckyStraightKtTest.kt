package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class LuckyStraightKtTest {
    @Test
    fun luckyStraightTest(){
        assertThat(luckyStraight(123402)).isEqualTo("LUCKY")
    }
}