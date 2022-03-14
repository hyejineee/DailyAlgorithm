package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class BinarySearchTest{
    val methods = BinarySearch()
    @Test
    fun findPartTest(){
        assertThat(methods.findPart(intArrayOf(8,3,7,9,2), intArrayOf(5,7,9))).isEqualTo("no yes yes")
    }

    @Test
    fun makeRiceCakeTest(){
        assertThat(methods.makeRiceCake(4,6, intArrayOf(19,14,10,17))).isEqualTo(15)
    }
}