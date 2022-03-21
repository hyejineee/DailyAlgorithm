package thisIsCodingTest

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val ps = readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val result = if (ps.size % 2 == 0) ps[ps.size / 2 - 1] else ps[ps.size / 2]
    println(result)
}