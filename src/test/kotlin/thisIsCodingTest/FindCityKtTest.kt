package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class FindCityKtTest {
    @Test
    fun findCityTest(){
        assertThat(findCity(4, arrayOf(
            intArrayOf(1,2),
            intArrayOf(1,3),
            intArrayOf(2,3),
            intArrayOf(2,4),
        ),1,1)).isEqualTo(intArrayOf(2,3))

        assertThat(findCity(4, arrayOf(
            intArrayOf(1,2),
            intArrayOf(1,3),
            intArrayOf(1,4),

        ),2,1)).isEqualTo(intArrayOf(-1))
    }
}