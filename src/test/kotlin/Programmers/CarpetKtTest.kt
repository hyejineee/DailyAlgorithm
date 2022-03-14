package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class CarpetKtTest{
    @Test
    fun carpetTest(){
        assertThat(carpet(10,2)).isEqualTo(intArrayOf(4,3))
        assertThat(carpet(8,1)).isEqualTo(intArrayOf(3,3))
        assertThat(carpet(24,24)).isEqualTo(intArrayOf(8,6))
        assertThat(carpet(18,6)).isEqualTo(intArrayOf(8,3))
        assertThat(carpet(14,4)).isEqualTo(intArrayOf(6,3))
        assertThat(carpet(50,22)).isEqualTo(intArrayOf(24,3))

    }
}