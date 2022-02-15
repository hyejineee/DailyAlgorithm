package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class HIndexKtTest{
    @Test
    fun hindexTest(){
//        assertThat(hIndex(intArrayOf(3,0,6,1,5))).isEqualTo(3)
//        assertThat(hIndex(intArrayOf(2,2,1,1,0))).isEqualTo(1)
//        assertThat(hIndex(intArrayOf(2,1,1,0))).isEqualTo(1)
        assertThat(hIndex(intArrayOf(9, 7, 6, 2, 1))).isEqualTo(3)
        assertThat(hIndex(intArrayOf(0,0,0,0,0))).isEqualTo(0)
        assertThat(hIndex(intArrayOf(1,4))).isEqualTo(1)
        assertThat(hIndex(intArrayOf(0,1,2))).isEqualTo(1)

    }
}