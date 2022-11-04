package Programmers.y2022._1104

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Assert.*
import org.junit.Test

class 메뉴_리뉴얼KtTest{
    @Test
    fun `메뉴_리뉴얼`(){
        assertThat(메뉴_리뉴얼(
            arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"),
            intArrayOf(2,3,4)
        )).isEqualTo(arrayOf("AC", "ACDE", "BCFG", "CDE"))
    }
}