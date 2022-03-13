package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val ts = readLine().toInt()
    for (t in 0 until ts) {
        val cs = readLine().split(" ").map { it.toInt() }

        val x1 = cs[0]
        val y1 = cs[1]
        val r1 = cs[2].toFloat()
        val x2 = cs[3]
        val y2 = cs[4]
        val r2 = cs[5].toFloat()

        if (x1 == x2 && y1 == y2 && r1 ==r2) {
            println(-1)
            continue
        }

        val d = sqrt(abs(x2 - x1).toFloat().pow(2) + abs(y2 - y1).toFloat().pow(2))

        if (abs(r2 - r1) < d && d < r1 + r2) {
            println(2)
            continue
        }

        if (r1 + r2 == d || abs(r2-r1) == d){
            println(1)
            continue
        }

        println(0)
    }
}

