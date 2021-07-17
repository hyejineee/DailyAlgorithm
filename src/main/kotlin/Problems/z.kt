package Problems

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun z(n: Long, r: Int, c: Int): Int {
    return findOrder(
        (2.0.pow(n.toDouble()) * 2.0.pow(n.toDouble())).toInt(),
        r,
        c,
        0
    )
}

fun findOrder(n: Int, r: Int, c: Int, start: Int): Int {

    println(n)

    val array = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 3)
    ).map {
        it.map {
            it + start
        }
    }

    val length = (sqrt(n.toDouble()) - 1).toInt()

    val where = when {
        r in 0..length / 2 && c in 0..length / 2 -> 0
        r in 0..length / 2 && c in (length / 2) + 1..length -> 1
        r in (length / 2) + 1..length && c in 0..length / 2 -> 2
        r in (length / 2) + 1..length && c in (length / 2) + 1..length -> 3
        else -> 0
    }
    println("r : $r, c: $c where : $where, start : $start, length : $length")

    if (n == 4) {
        return array[r][c]
    } else {
        val row = if ((r - sqrt((n / 4).toDouble())).roundToInt() >= 0) {
            (r - sqrt((n / 4).toDouble())).roundToInt()
        } else {
            r
        }
        val col = if ((c - sqrt((n / 4).toDouble())).roundToInt() >= 0) {
            (c - sqrt((n / 4).toDouble())).roundToInt()
        } else {
            c
        }
        return findOrder(
            n / 4,
            row,
            col,
            n / 4 * where + start
        )
    }

}


