package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class ImmigrationKtTest{

    @Test
    fun immigrationTest(){
        assertThat(immigration(6, intArrayOf(7,10))).isEqualTo(28)
        assertThat(immigration(3, intArrayOf(1,1,1))).isEqualTo(1)
        assertThat(immigration(3, intArrayOf(1,2,3))).isEqualTo(2)
        assertThat(immigration(10, intArrayOf(6,8,10))).isEqualTo(30)


    }
}