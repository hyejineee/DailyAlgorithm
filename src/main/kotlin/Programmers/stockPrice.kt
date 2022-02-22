package Programmers

import java.util.*

fun stockPrice(prices:IntArray): IntArray {

    val ps = prices.mapIndexed { index, i -> intArrayOf(index +1, i)  }

    return IntArray(prices.size){ i ->
        val (s, p) = ps[i]
        val (es, _) = ps.subList(i, prices.size).takeWhile { it[1] >= p }.last()

        (if(es == prices.size)es else es +1) - s
    }
}