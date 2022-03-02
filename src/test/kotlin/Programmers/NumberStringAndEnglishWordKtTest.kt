package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class NumberStringAndEnglishWordKtTest{
    @Test
    fun numberStringAndEnWordTest(){
        assertThat(numberStringAndEnWord("one4seveneight")).isEqualTo(1478)
    }
}