package BOJ.y2022.implementation

import java.io.BufferedReader
import java.io.InputStreamReader

data class Info(
    val x: Int,
    val y: Int,
    val favoriteCount: Int,
    val emptyCount: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val favorites = (1..n * n).map { readLine().split(" ").map { it.toInt() }.toIntArray() }.toTypedArray()
    val arr = Array<IntArray>(n) { IntArray(n) { 0 } }
    val indexes = Array(n) { IntArray(n) { 0 } }

    favorites.forEachIndexed { index, ints ->
        setPosition(arr, indexes, ints.drop(1).toIntArray(), ints[0], n, index)
    }

    val total = calculateSatisfaction(favorites, indexes, arr, n)

    println("$total")

}

private fun calculateSatisfaction(fs: Array<IntArray>, indexes: Array<IntArray>, arr: Array<IntArray>, n: Int): Int {

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    var total = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            val f = fs[indexes[i][j]]
            var fc = 0
            for (k in 0..3) {
                if (!(i + dx[k] in 0 until n && j + dy[k] in 0 until n)) continue
                if (arr[i + dx[k]][j + dy[k]] in f) fc++
            }

            total += when (fc) {
                0 -> 0
                1 -> 1
                2 -> 10
                3 -> 100
                else -> 1000
            }
        }
    }
    return total
}

private fun setPosition(
    arr: Array<IntArray>,
    indexes: Array<IntArray>,
    favorites: IntArray,
    me: Int,
    n: Int,
    index: Int
) {

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val infos = mutableListOf<Info>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] != 0) continue

            var fc = 0
            var ec = 0

            for (k in 0..3) {
                if (!(i + dx[k] in 0 until n && j + dy[k] in 0 until n)) continue

                if (arr[i + dx[k]][j + dy[k]] in favorites) fc++
                if (arr[i + dx[k]][j + dy[k]] == 0) ec++
            }

            infos.add(Info(i, j, fc, ec))
        }
    }

    val p = infos.sortedWith(compareBy({ -it.favoriteCount }, { -it.emptyCount }, { it.x }, { it.y })).first()

    arr[p.x][p.y] = me
    indexes[p.x][p.y] = index
}