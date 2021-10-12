package Problems

import kotlin.math.max

fun saveCastle(n: Int, m: Int, castle: Array<CharArray>): Int {

    val row = MutableList(n) { false }
    val col = MutableList(m) { false }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (castle[i][j] == 'x') {
                row[i] = true
                col[j] = true
            }
        }
    }

    val rowCount = row.count { !it }
    val colCount = col.count { !it }

    return max(rowCount, colCount)
}