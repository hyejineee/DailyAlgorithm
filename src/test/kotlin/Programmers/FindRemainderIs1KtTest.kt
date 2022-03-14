package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class FindRemainderIs1KtTest{
    @Test
    fun findRemainderIs1Test(){
        assertThat(findRemainderIs1(10)).isEqualTo(3)
        assertThat(findRemainderIs1(12)).isEqualTo(11)
    }
}