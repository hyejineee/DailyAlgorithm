package codility

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class TapeEquilibriumKtTest{
    @Test
    fun tapeEquilibriumTest(){
        assertThat(tapeEquilibrium(intArrayOf(3,1,2,4,3))).isEqualTo(1)
        assertThat(tapeEquilibrium(intArrayOf(-1000, 1000))).isEqualTo(2000)
    }
}