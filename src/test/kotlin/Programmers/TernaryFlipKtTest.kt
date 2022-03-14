package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class TernaryFlipKtTest{
    @Test
    fun ternaryFlipTest(){
        assertThat(ternaryFlip(45)).isEqualTo(7)
        assertThat(ternaryFlip(125)).isEqualTo(229)
    }
}