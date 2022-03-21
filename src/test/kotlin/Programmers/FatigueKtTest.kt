package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import junit.framework.TestCase
import org.junit.Test

class FatigueKtTest {
    @Test
    fun fatigueTest(){
//        assertThat(fatigue(80, arrayOf(intArrayOf(80,20), intArrayOf(50,40), intArrayOf(30,10)))).isEqualTo(3)
        assertThat(fatigue(80, arrayOf(intArrayOf(100,20), intArrayOf(50,40), intArrayOf(30,10)))).isEqualTo(2)
    }

}