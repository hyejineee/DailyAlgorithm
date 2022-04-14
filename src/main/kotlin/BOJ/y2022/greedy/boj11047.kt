package BOJ.y2022.greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = (0 until n).map { readLine().toInt() }.reversed().toIntArray()


    var remain = k
    var total = 0
    while (remain > 0) {
        val m = coins.find { it <= remain }!!
        val count = remain / m
        remain -= (m * count)
        total += count
    }

    println(total)

}

