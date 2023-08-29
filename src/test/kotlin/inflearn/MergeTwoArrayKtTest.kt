package inflearn

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class MergeTwoArrayKtTest {

    @Test
    fun mergeTwoArray() {
        val result = inflearn.mergeTwoArray(intArrayOf(1,3,5), intArrayOf(2,3,6,7,9))

        assertk.assertThat(result).isEqualTo(intArrayOf(1,2,3,3,5,6,7,9))
    }
}