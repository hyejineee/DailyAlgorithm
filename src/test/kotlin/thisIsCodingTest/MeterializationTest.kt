package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class MeterializationTest{
    val methods = Meterialization()

    @Test
    fun UDLRTest(){
        assertThat(methods.UDLR(5, "R R R U D D")).isEqualTo(intArrayOf(3,4))
    }

    @Test
    fun timeTest(){
        assertThat(methods.time(5)).isEqualTo(11475)
    }

    @Test
    fun royalKnightTest(){
        assertThat(methods.royalKnight("a1")).isEqualTo(2)
    }
}