package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val q = LinkedList<Int>()
    val sb = StringBuilder()
    (1..n).forEach {
        readLine().split(" ").also {
            when (it[0]) {
                "push" -> q.add(it[1].toInt())
                "pop" -> sb.append("${q.poll() ?: -1}\n")
                "size" -> sb.append("${q.size}\n")
                "empty" -> sb.append("${if (q.isEmpty()) 1 else 0}\n")
                "front" -> sb.append("${if (q.isEmpty()) -1 else q.first}\n")
                "back" -> sb.append("${if (q.isEmpty()) -1 else q.last}\n")
            }
        }
    }
    print(sb.toString())
}
