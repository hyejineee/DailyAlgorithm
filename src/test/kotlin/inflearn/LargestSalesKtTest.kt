package inflearn

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class LargestSalesKtTest {

    @Test
    fun largestSales() {
        val result = inflearn.largestSales(intArrayOf(12,15,11,20,25,10,20,19,13,15), 3)

        assertk.assertThat(result).isEqualTo(56)
    }
}