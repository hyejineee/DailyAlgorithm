package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sorted = (0 until n).map { readLine().split(" ").map { it.toInt() } }.sortedWith(compareBy({it[0]},{it[1]}))

    sorted.forEach { (x,y)->
        println("$x $y")
    }
}

