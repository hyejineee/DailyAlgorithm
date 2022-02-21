package thisIsCodingTest

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class GreedyKtTest{
    @Test
    fun changeTest(){
        assertThat(change(1260)).isEqualTo(6)
    }

    @Test
    fun lawOfLargeNumberTest(){
        assertThat(lawOfLargeNumber(8,3, intArrayOf(2,4,5,4,6))).isEqualTo(46)
        assertThat(lawOfLargeNumber(7,2, intArrayOf(3,4,3,4,3))).isEqualTo(28)
    }

    @Test
    fun numberCardGameTest(){
        assertThat(numberCardGame(
            arrayOf(
                intArrayOf(7,3,1,8),
                intArrayOf(3,3,3,4)
            )
        )).isEqualTo(3)

        assertThat(numberCardGame(
            arrayOf(
                intArrayOf(3,1,2),
                intArrayOf(4,1,4),
                intArrayOf(2,2,2)
            )
        )).isEqualTo(2)
    }
}