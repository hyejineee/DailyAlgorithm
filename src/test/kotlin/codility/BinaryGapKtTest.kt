package codility

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class BinaryGapKtTest{
    @Test
    fun binaryGapTest(){
        assertThat(binaryGap(9)).isEqualTo(2)
        assertThat(binaryGap(529)).isEqualTo(4)
        assertThat(binaryGap(20)).isEqualTo(1)

    }
}