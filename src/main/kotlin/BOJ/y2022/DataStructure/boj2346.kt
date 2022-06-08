package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val balloons = readLine().split(" ").mapIndexed { index, s -> Pair(index + 1, s.toInt()) }.toMutableList()

    var index = 0
    var k = balloons[0].second

    val pops = mutableListOf<Pair<Int, Int>>().apply { add(balloons.removeAt(0)) }

    while (balloons.isNotEmpty()) {

        index = if (k < 0) (index + k) % balloons.size else (index + (k - 1)) % balloons.size
        index = if(index < 0) balloons.size + index else index

        val p = balloons.removeAt(index)

        pops.add(p)
        k = p.second
    }

    println(pops.map { it.first}.joinToString(" "))
}
