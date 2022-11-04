package Programmers.y2022._1103

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Assert.*
import org.junit.Test

class 연속_부분_수열_합의_개수KtTest{
    @Test
    fun `연속_부분_수열_합의_개수`(){
        assertThat(`연속 부분 수열 합의 개수`(intArrayOf(7,9,1,1,4))).isEqualTo(18)
    }
}