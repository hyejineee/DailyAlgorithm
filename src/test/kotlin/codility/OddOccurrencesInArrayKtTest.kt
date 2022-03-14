package codility

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class OddOccurrencesInArrayKtTest{
    @Test
    fun oddOccurrencesInArrayTest(){
        assertThat(oddOccurrencesInArray(intArrayOf(9,3,9,3,9,7,9))).isEqualTo(7)
    }
}