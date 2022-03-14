package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class AddNumberNotExistKtTest{

    @Test
    fun addNumberNBotExistTest(){
        assertThat(addNumberNotExist(intArrayOf(1,2,3,4,6,7,8,0))).isEqualTo(14)
    }
}