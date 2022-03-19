package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    while (true) {
        val cs = readLine().split(" ").map { it.toInt() }.toIntArray()

        if (cs.all { it == 0 }) break

        cs.sort()

        if (cs.last().toFloat().pow(2) == cs[0].toFloat().pow(2) + cs[1].toFloat()
                .pow(2)
        ) println("right\n") else println("wrong\n")

    }
}

