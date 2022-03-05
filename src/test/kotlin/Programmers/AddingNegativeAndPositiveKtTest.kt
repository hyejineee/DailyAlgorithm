package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class AddingNegativeAndPositiveKtTest{
    @Test
    fun addingNegativeAndPositiveTest(){
        assertThat(addingNegativeAndPositive(intArrayOf(4,7,12), booleanArrayOf(true,false,true))).isEqualTo(9)
    }
}