package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class DPTest{
    val methods = DP()

    @Test
    fun make1Test(){
        assertThat(methods.make1(26)).isEqualTo(3)
    }

    @Test
    fun antWarriorTest(){
        assertThat(methods.antWarrior(intArrayOf(1,3,1,5))).isEqualTo(8)
    }
}
