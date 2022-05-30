package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val q = LinkedList<Int>(List(n) { it + 1 })

    while (q.size > 1) {
        q.pollFirst()
        q.add(q.pollFirst())
    }

    println(q.poll())
}
