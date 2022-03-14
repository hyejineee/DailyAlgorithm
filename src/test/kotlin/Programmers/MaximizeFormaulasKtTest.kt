package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class MaximizeFormulasKtTest {
    @Test
    fun maximizeFormulasTest(){
        assertThat(maximizeFormulas("100-200*300-500+20")).isEqualTo(60420)
        assertThat(maximizeFormulas("50*6-3*2")).isEqualTo(300)
        assertThat(maximizeFormulas("999*999*999")).isEqualTo(997002999)
        assertThat(maximizeFormulas("1+1")).isEqualTo(2)
        assertThat(maximizeFormulas("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99")).isEqualTo(6083974714)

    }
}