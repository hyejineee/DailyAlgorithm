package Programmers.y2022._1104

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Assert.*
import org.junit.Test

class 두_큐_합_같게_만들기KtTest{
    @Test
    fun `두 큐 합 같게 만들기`(){
        assertThat(두_큐_합_같게_만들기(intArrayOf(3, 2, 7, 2), intArrayOf(4,6,5,1))).isEqualTo(2)
    }
}