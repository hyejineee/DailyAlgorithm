package BOJ

import java.beans.beancontext.BeanContextServiceAvailableEvent
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess


private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val garden = MutableList(n) {
            readLine().split(" ").map { it.toInt() }
        }

        val isAvailableZone = MutableList(n) { i ->
            MutableList(n) { true }
        }

        var result = 0
        var count = 0

        while (count !=3) {
            val (min, x, y) = findMinMoney(isAvailableZone, n, garden)
            if (min == 20000) continue

            result += min
            count++
        }

        println(result)
        exitProcess(0)
    }
}

private fun findMinMoney(
    isAvailableZone: MutableList<MutableList<Boolean>>,
    n: Int,
    garden: MutableList<List<Int>>
): List<Int> {

    var min = 20000
    var minX = -1
    var minY = -1

    for (i in 0 until n ) {
        for (j in 0 until n ) {

            if((i == 0) or (i == n-1) or (j == 0) or (j == n-1)) continue

            if (isAvailableZone[i][j].not()) continue
            if (isAvailableZone[i - 1][j].not()) continue
            if (isAvailableZone[i + 1][j].not()) continue
            if (isAvailableZone[i][j - 1].not()) continue
            if (isAvailableZone[i][j + 1].not()) continue

            var price = garden[i][j]

            for (k in dx.indices) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                price += garden[nx][ny]
            }

            if (price < min) {
                min = price
                minX = i
                minY = j
            }
        }
    }

    isAvailableZone[minX][minY] = false
    for (k in dx.indices) {
        val nx = minX + dx[k]
        val ny = minY + dy[k]

        isAvailableZone[nx][ny] = false
    }

    return listOf(min, minX, minY)
}