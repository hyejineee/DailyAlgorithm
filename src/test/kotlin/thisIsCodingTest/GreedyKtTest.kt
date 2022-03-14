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

    @Test
    fun untilBecome1Test(){
        assertThat(untilBecomes1(17, 4)).isEqualTo(3)
        assertThat(untilBecomes1(25, 5)).isEqualTo(2)
        assertThat(untilBecomes1(25, 3)).isEqualTo(6)
    }

    @Test
    fun adventurersGuideTest(){
        assertThat(adventurersGuide(5, intArrayOf(2,3,1,2,2))).isEqualTo(2)
    }

    @Test
    fun multiplyOrAddTest(){
        assertThat(multiplyOrAdd("02984")).isEqualTo(576)
        assertThat(multiplyOrAdd("567")).isEqualTo(210)
    }

    @Test
    fun flipString(){
        assertThat(thisIsCodingTest.flipString("0001100")).isEqualTo(1)
        assertThat(thisIsCodingTest.flipString("11001100110011000001")).isEqualTo(4)
    }

    @Test
    fun noMadeMoney(){
        assertThat(notMadeMoney(5, intArrayOf(3,2,1,1,9))).isEqualTo(8)
    }
}