package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class IntegerTriangleKtTest{

    @Test
    fun integerTriangleTest(){
        assertThat(
            integerTriangle(
                arrayOf(
                    intArrayOf(7,0,0,0,0),
                    intArrayOf(3,8,0,0,0),
                    intArrayOf(8,1,0,0,0),
                    intArrayOf(2,7,4,4,0),
                    intArrayOf(4,5,2,6,5),
                )
            )
        ).isEqualTo(
            30
        )
    }
}