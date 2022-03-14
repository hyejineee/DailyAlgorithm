package Programmers

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test


internal class StockPriceKtTest{

    @Test
    fun stockPriceTest(){
        assertThat(stockPrice(intArrayOf(1,2,3,2,3,1))).isEqualTo(intArrayOf(5,4,1,2,1,0))
        assertThat(stockPrice(intArrayOf(1,2,3,2,3))).isEqualTo(intArrayOf(4,3,1,1,0))
    }
}