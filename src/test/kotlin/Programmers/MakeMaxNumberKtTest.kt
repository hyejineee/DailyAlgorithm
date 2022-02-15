package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class MakeMaxNumberKtTest{

    @Test
    fun makeMaxNumberTest(){
//        assertThat(makeMaxNumber(intArrayOf(3,30,34,5,9))).isEqualTo("9543330")
        assertThat(makeMaxNumber(intArrayOf(0))).isEqualTo("0")
    }
}