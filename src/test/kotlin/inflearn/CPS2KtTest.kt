package inflearn

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class CPS2KtTest {

    @Test
    fun cps2() {
        val result = inflearn.cps2(intArrayOf(1,3,1,2,3), 5)
        assertk.assertThat(result).isEqualTo(10)
    }
}