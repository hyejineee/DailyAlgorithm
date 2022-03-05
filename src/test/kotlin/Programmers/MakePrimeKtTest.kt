package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class MakePrimeKtTest{
    @Test
    fun makePrimeTest(){
        assertThat(makePrime(intArrayOf(1,2,7,6,4))).isEqualTo(4)
    }
}