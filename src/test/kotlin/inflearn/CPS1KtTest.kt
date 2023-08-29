package inflearn

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class CPS1KtTest {

    @Test
    fun cps1() {
        val result = inflearn.cps1(intArrayOf(1,2,1,3,1,1,1,2), 6)
        assertk.assertThat(result).isEqualTo(3)
    }
}