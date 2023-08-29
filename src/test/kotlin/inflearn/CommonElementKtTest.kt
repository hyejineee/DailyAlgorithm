package inflearn

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class CommonElementKtTest {

    @Test
    fun commonElement() {
        val result = inflearn.commonElement(intArrayOf(1,3,9,5,2), intArrayOf(3,2,5,7,8))

        assertk.assertThat(result).isEqualTo(intArrayOf(2,3,5))
    }
}