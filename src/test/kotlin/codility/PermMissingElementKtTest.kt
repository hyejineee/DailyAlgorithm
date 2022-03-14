package codility

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class PermMissingElementKtTest{
    @Test
    fun permMissingElementTest(){
        assertThat(permMissingElement(intArrayOf(2,3,1,5))).isEqualTo(4)
    }
}