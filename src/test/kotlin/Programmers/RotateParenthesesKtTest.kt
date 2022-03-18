package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class RotateParenthesesKtTest {
    @Test
    fun rotateParenthesesTest() {
        assertThat(rotateParentheses("[](){}")).isEqualTo(3)
        assertThat(rotateParentheses("}]()[{")).isEqualTo(2)
        assertThat(rotateParentheses("[)(]")).isEqualTo(0)
        assertThat(rotateParentheses("}}}")).isEqualTo(0)
    }
}