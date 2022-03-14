package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class ParenthesesConversionKtTest {
    @Test
    fun parenthesesConversionTest(){
        assertThat(parenthesesConversion(")(")).isEqualTo("()")
        assertThat(parenthesesConversion("()))((()")).isEqualTo("()(())()")
    }
}