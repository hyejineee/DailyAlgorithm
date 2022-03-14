package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class MockTestKtTest{

    @Test
    fun mockTestTest(){
        assertThat(mockTest(intArrayOf(1,2,3,4,5))).isEqualTo(intArrayOf(1))
        assertThat(mockTest(intArrayOf(1,3,2,4,2))).isEqualTo(intArrayOf(1,2,3))
    }
}