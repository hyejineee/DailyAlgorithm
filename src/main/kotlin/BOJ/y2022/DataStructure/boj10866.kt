package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val d = LinkedList<Int>()
    (1..readLine().toInt()).forEach {
        readLine().split(" ").also {
            when (it[0]) {
                "push_front" -> {
                    d.offerFirst(it[1].toInt())
                }
                "push_back" -> {
                    d.offerLast(it[1].toInt())
                }
                "pop_front" -> {
                    sb.append("${d.pollFirst() ?: -1}\n")
                }
                "pop_back" -> {
                    sb.append("${d.pollLast() ?: -1}\n")
                }
                "size" -> {
                    sb.append("${d.size}\n")
                }
                "empty" -> {
                    sb.append("${if (d.isEmpty()) 1 else 0}\n")
                }
                "front" -> {
                    sb.append("${d.firstOrNull() ?: -1}\n")
                }
                "back" -> {
                    sb.append("${d.lastOrNull()?:-1}\n")
                }
            }
        }

    }

    print(sb.toString())
}
