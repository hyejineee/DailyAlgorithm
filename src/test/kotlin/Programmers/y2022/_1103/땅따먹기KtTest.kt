package Programmers.y2022._1103


import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class 땅따먹기KtTest(){
    @Test
    fun `땅따먹기`(){
        assertThat(땅따먹기(arrayOf(
            intArrayOf(1,2,3,5),
            intArrayOf(5,6,7,8),
            intArrayOf(4,3,2,1),
        ))).isEqualTo(16)
    }
}