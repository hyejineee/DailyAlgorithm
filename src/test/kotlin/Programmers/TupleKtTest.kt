package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class TupleKtTest {
    @Test
    fun tupleTest() {
        assertThat(tuple("{{4,2,3},{3},{2,3,4,1},{2,3}}")).isEqualTo(intArrayOf(3, 2, 4, 1))
        assertThat(tuple("{{1,2,3},{2,1},{1,2,4,3},{2}}"	)).isEqualTo(intArrayOf(2,1,3,4))
        assertThat(tuple("{{20,111},{111}}"		)).isEqualTo(intArrayOf(111,20))
        assertThat(tuple("{{123}}"	)).isEqualTo(intArrayOf(123))
    }
}