package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test
import kotlin.math.pow

class ExpectedDrawKtTest {
    @Test
    fun expectedDrawTest(){
        assertThat(expectedDraw(8,4,7)).isEqualTo(3)
        assertThat(expectedDraw(16,4,16)).isEqualTo(4)
        assertThat(expectedDraw(16,1,8)).isEqualTo(3)
        assertThat(expectedDraw(16,9,16)).isEqualTo(3)
        assertThat(expectedDraw(16,8,9)).isEqualTo(4)
        assertThat(expectedDraw(16,2,4)).isEqualTo(2)
        assertThat(expectedDraw(16,1,2)).isEqualTo(1)
        assertThat(expectedDraw(16,9,12)).isEqualTo(2)
        assertThat(expectedDraw(16,9,10)).isEqualTo(1)
        assertThat(expectedDraw(16,10,9)).isEqualTo(1)
        assertThat(expectedDraw(8,1,2)).isEqualTo(1)
        assertThat(expectedDraw(8,2,3)).isEqualTo(2)
        assertThat(expectedDraw(8,4,5)).isEqualTo(3)
        assertThat(expectedDraw(2.0.pow(20).toInt(),1,2.0.pow(20).toInt())).isEqualTo(20)
    }

}