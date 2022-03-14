package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class WordConversionKtTest{
    @Test
    fun `network problem test`() {
//        assertThat(
//            wordConversion("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
//        ).isEqualTo(4)
//
//        assertThat(
//            wordConversion("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog", "cit", "cot"))
//        ).isEqualTo(3)

        assertThat(
            wordConversion("hit", "hhh", arrayOf("hhh", "hht"))
        ).isEqualTo(2)
    }
}