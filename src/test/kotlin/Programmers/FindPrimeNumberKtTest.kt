package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class FindPrimeNumberKtTest{
    @Test
    fun findPrimeNumberTest(){
        assertThat(findPrimeNumber("17")).isEqualTo(3)
        assertThat(findPrimeNumber("011")).isEqualTo(2)
        assertThat(findPrimeNumber("1231")).isEqualTo(18)
    }
}