package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val testCase = readLine().toInt()

        for (i in 0 until testCase) {
            val (c, doc) = readLine().split(" ").map { it.toInt() }
            val p = readLine().split(" ").map { it.toInt() }.toIntArray()
            println(printerQueue(c, doc, p))
        }
    }
}

fun printerQueue(count: Int, doc: Int, priority: IntArray): Int {

    val q = LinkedList<Pair<Int, Int>>()

    (0 until count).forEach {
        q.add(Pair(priority[it], it))
    }

    var printed = -1
    var c = 0

    while (printed != doc) {

        val d = q.removeFirst()

        if ((q.count { it.first > d.first }) > 0) {
            q.add(d)
        } else {
            c++
            printed = d.second
        }

    }

    return c
}