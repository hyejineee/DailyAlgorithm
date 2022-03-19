package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val cs = (0 until 3).map {
        readLine().split(" ").map { it.toInt() }
    }

    val set1 = mutableSetOf<Int>()
    val set2 = mutableSetOf<Int>()

    for (i in cs.indices) {
        val (x, y) = cs[i]

        if (set1.contains(x)) {
            set1.remove(x)
        } else {
            set1.add(x)
        }

        if (set2.contains(y)) {
            set2.remove(y)
        } else {
            set2.add(y)
        }
    }

    bw.write("${set1.first()} ${set2.first()}")
    bw.flush()
    bw.close()
}

