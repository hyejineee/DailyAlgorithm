package leetCode.y2023

import assertk.assertions.isEqualTo
import org.junit.Test

import org.junit.Assert.*

class N2294KtTest {

    @Test
    fun partitionArray() {
        val result = leetCode.y2023.partitionArray(intArrayOf(3,6,1,2,5), 2)

        assertk.assertThat(result).isEqualTo(2)
    }
}