package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

internal class SkillCheck1Test{

    val problems = SkillCheck1()
    @Test
    fun `문제 1 테스트`(){
        assertThat(
            problems.problem1(intArrayOf(2,1,3,4,1))
        ).isEqualTo(
            intArrayOf(2,3,4,5,6,7)
        )
    }


    @Test
    fun problem2Test(){
        assertThat(
            problems.problem2(intArrayOf(1,2,3,4,6,7,8,0))
        ).isEqualTo(14)
    }
}