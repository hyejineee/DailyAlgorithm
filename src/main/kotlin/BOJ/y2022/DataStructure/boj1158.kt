package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val q = LinkedList<Int>(List(n) { it + 1 })
    val sb = StringBuilder()
    sb.append("<")
    var idx = k - 1
    while (q.size > 1) {
        sb.append("${q[idx]}, ")
        q.removeAt(idx)
        idx = (idx + (k - 1)) % q.size
    }
    sb.append("${q.poll()}>")
    println(sb.toString())
}
