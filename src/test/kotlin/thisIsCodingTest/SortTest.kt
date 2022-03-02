package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class SortTest{
    private val methods = Sort()

    @Test
    fun topDownTest(){
        assertThat(methods.topDown(intArrayOf(15,27,12))).isEqualTo(intArrayOf(27,15,12))
    }

    @Test
    fun printStudentsTest(){
        assertThat(methods.printStudents(arrayOf("홍길동 95", "이순신 77"))).isEqualTo("이순신 홍길동")
    }

    @Test
    fun swapElementTwoArraysTest(){
        assertThat(methods.swapElementTowArrays(
            intArrayOf(1,2,5,4,3),
            intArrayOf(5,5,6,6,5),
            3
        )).isEqualTo(26)
    }
}