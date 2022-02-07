package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class WayToSchoolKtTest{
    @Test
    fun waytoSchoolTest(){
        assertThat(wayToSchool(4,3, arrayOf(intArrayOf(2,2)))).isEqualTo(4)

        assertThat(wayToSchool(4,3, arrayOf(intArrayOf(1,2), intArrayOf(2,1)))).isEqualTo(0)
    }
}