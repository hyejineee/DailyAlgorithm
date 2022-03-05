package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class NumberAndAddingOfAliquotKtTest{
    @Test
    fun numberAndAddingOfAliquotTest(){
        assertThat(numberAndAddingOfAliquot(13,17)).isEqualTo(43)
        assertThat(numberAndAddingOfAliquot(24,27)).isEqualTo(52)

    }
}