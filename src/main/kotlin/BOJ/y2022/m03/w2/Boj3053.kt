package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val r = readLine().toInt()

    val u:Double = r * r * PI
    val t:Double = 2.0 * r * r

    println(String.format("%.6f", u))
    println(String.format("%.6f",t))
}

