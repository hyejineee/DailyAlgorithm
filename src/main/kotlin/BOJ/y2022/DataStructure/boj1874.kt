package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = (1..readLine().toInt()).map { readLine().toInt() }
    val s = Stack<Int>()

    val sb = StringBuilder()
    var pushed = 0
    for (i in arr) {
        if (i > pushed && i !in s) {
            repeat(i - pushed) {
                s.push(pushed + 1)
                pushed++
                sb.append("+\n")
            }
        }

        if (s.isNotEmpty() && i == s.peek()) {
            s.pop()
            sb.append("-\n")
        }
    }

    print(if (s.isNotEmpty()) "NO" else sb.toString())
}
