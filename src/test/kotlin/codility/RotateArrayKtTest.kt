package codility

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class RotateArrayKtTest{
    @Test
    fun rotateArrayTest(){
        assertThat(rotateArray(intArrayOf(3,8,9,7,6), 1)).isEqualTo(intArrayOf(6,3,8,9,7))
    }
}