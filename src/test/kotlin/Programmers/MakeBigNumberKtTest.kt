package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class MakeBigNumberKtTest{
    @Test
    fun makeBigNumberTest(){
        assertThat(makeBigNumber("1924",2)).isEqualTo("94")
        assertThat(makeBigNumber("1231234",3)).isEqualTo("3234")
        assertThat(makeBigNumber("4177252841",4)).isEqualTo("775841")
        assertThat(makeBigNumber("654321",5)).isEqualTo("6")
    }
}