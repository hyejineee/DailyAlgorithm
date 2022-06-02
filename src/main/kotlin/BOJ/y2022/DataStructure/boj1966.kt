package BOJ.y2022.DataStructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    (1..readLine().toInt()).forEach {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val docs = readLine().split(" ").mapIndexed { index, s -> index to s.toInt() }.toMutableList()
        var count = 0
        var printed = -1

        while (docs.isNotEmpty() && printed != m){
            val p = docs.removeFirst()

            docs.find { it.second > p.second }?.also {
                docs.add(p)
            }?: kotlin.run{
                count++
                printed = p.first
            }
        }

        println(count)
    }
}
